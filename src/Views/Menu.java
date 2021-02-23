package Views;

import Entities.User;

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);

    public static User getUserInfo(){
        User user = new User();
        System.out.println("Enter User's name");
            String userName = input.nextLine();
            user.setName(userName);
        System.out.println("Enter User's telephone");
            int tel = Integer.parseInt(input.nextLine());
            user.setTel(tel);
        System.out.println("Enter User's address");
            String address = input.nextLine();
            user.setAddress(address);
        System.out.println("Enter User's email");
            String email = input.nextLine();
            user.setEmail(email);
        System.out.println("Enter User's facebook account");
            String facebookAccount = input.nextLine();
            user.setFacebook(facebookAccount);
        return user;
    }
}
