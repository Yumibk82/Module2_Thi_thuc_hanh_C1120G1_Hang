package Behaviors;

import Entities.User;

import java.io.IOException;
import java.util.ArrayList;

public class UserManagement {

//    String path = "C:\\Users\\Tuan\\IdeaProjects\\Thi_thuc_hanh_Module2_C1120G1_Hang\\src\\database.csv";
    static ArrayList<User> users = ReadWriteFile.readUserFileCSV();
    public void addUser(User user) throws IOException {
        users.add(user);
        ReadWriteFile.writeUserToFileCSV(users);
    }

    public void updateUser(User user){
        for (User eUser: users) {
            if(eUser.getTel() == user.getTel()){
                eUser.setName(user.getName());
                eUser.setEmail(user.getEmail());
                eUser.setAddress(user.getAddress());
                eUser.setFacebook(user.getFacebook());
            }
        }
    }
    public void removeUser(int tel) throws IOException {
        for (User eUser: users) {
            if(eUser.getTel() == tel){
                users.remove(eUser);
            }
        }
        ReadWriteFile.writeUserToFileCSV(users);
    }
    public void search(int tel){
        for (User eUser: users) {
            if(eUser.getTel() == tel){
                System.out.println(eUser.toString());
            }
        }
        System.out.println("User is not existing!!!");;
    }
    public void showUserInfo(){
        for (User eUser: users) {
            System.out.println(eUser.toString());
        }
    }

}
