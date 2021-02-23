package Behaviors;
import Entities.User;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
public class ReadWriteFile {
    private static final String COMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String PATH = "C:\\Users\\Tuan\\IdeaProjects\\Thi_thuc_hanh_Module2_C1120G1_Hang\\src\\database.csv";
    private static final String FILE_HEADER = "name, tel, address, email,facebook";
    public static void writeUserToFileCSV(ArrayList<User> users) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(PATH);
            fw.append(FILE_HEADER);
            fw.append(NEW_LINE_SEPARATOR);
            for (User user : users ) {
                fw.append(user.getName());
                fw.append(COMA_DELIMITER);
                fw.append(String.valueOf(user.getTel()));
                fw.append(COMA_DELIMITER);
                fw.append(user.getAddress());
                fw.append(COMA_DELIMITER);
                fw.append(user.getEmail());
                fw.append(COMA_DELIMITER);
                fw.append(user.getFacebook());
                fw.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi ghi file CSV!");
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (Exception e) {
                System.out.println("Lỗi khi đóng luồng và đồng bộ!");
            }
        }
    }
    public static ArrayList<User> readUserFileCSV() {
        BufferedReader br = null;
        ArrayList<User> users = new ArrayList<>();
        Path path = Paths.get(PATH);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            br = new BufferedReader(new FileReader(PATH));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("phoneNumber")) {
                    continue;
                }
                User user = new User();
                user.setName(splitData[0]);
                user.setTel(Integer.parseInt(splitData[1]));
                user.setAddress(splitData[2]);
                user.setEmail(splitData[3]);
                user.setFacebook(splitData[4]);
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return users;
    }
}