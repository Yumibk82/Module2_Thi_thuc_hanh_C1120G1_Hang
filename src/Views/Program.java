package Views;
import Behaviors.UserManagement;
import Entities.User;

import java.util.Scanner;

public class Program {
    static UserManagement userManagement = new UserManagement();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        do{
            System.out.println("============CONTACT MANAGEMENT============");
            System.out.println("Please enter your choice a below number:");
            System.out.println("1. User list Display");
            System.out.println("2. Add new user");
            System.out.println("3. Update a user's information");
            System.out.println("4. Delete a user");
            System.out.println("5. Search a user");
            System.out.println("6. Read from file");
            System.out.println("7. Write to file");
            System.out.println("8. Exit");
            System.out.println("==========================================");
            System.out.println("What function do you want to do?");

            try{
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        userManagement.showUserInfo();
                        break;
                    case 2:
                        User userAdd = Menu.getUserInfo();
                        userManagement.addUser(userAdd);
                        break;
                    case 3:
                        User userUpdate = Menu.getUserInfo();
                        userManagement.updateUser(userUpdate);
                        break;
                    case 4:
                        System.out.println("Enter a telephone number of user to delete");
                        int telDelete = Integer.parseInt(input.nextLine());
                        userManagement.removeUser(telDelete);
                        break;
                    case 5:
                        System.out.println("Enter a telephone number of user to search");
                        int telSearch = Integer.parseInt(input.nextLine());
                        userManagement.search(telSearch);
                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:
                        System.out.println("Exit programing");
                        break;
                }

            }catch (NumberFormatException e){
                System.out.println("Please enter a number form 1 to 8");
            }
        }while (choice != 8);
    }
}
