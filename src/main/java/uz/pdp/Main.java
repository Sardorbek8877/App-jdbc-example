package uz.pdp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i=-1;

        while(i!=1){
            System.out.println("0=>Exit, 1=>New User, 2=>Edit User, 3=>Delete User, 4=>List User");
            i = scanner.nextInt();
            scanner= new Scanner(System.in);
            DataBaseService dataBaseService = new DataBaseService();
            switch (i){
                case 1:
                    System.out.println("Enter firstname");
                    String firstname = scanner.nextLine();
                    System.out.println("Enter lastname");
                    String lastname = scanner.nextLine();
                    System.out.println("Enter username");
                    String username = scanner.nextLine();
                    System.out.println("Enter password");
                    String password = scanner.nextLine();
                    User user = new User(firstname, lastname, username, password);
                    dataBaseService.saveUser(user);

                    break;
                case 2:
                    System.out.println("Edit User");
                    break;
                case 3:
                    System.out.println("Enter user's id.");
                    int id=scanner.nextInt();
                    dataBaseService.deleteUser(id);
                    break;
                case 4:
                    dataBaseService.getUsers();
                    break;
            }
        }
    }
}
