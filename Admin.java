
package recruitmentmanagement;

import java.util.*;
class Admin {
    private String username;
    private String password;
    Scanner s = new Scanner(System.in);

    boolean login() {
        final String Username = "Admin";// Admin ka username constant kia hai ye
        final String Password = "123456";// Admin ka password constant kia hai ye
        System.out.println("Login to access Admin console of Recruitment System\n");
        System.out.println("-Sign in-\n");

        System.out.println("Enter Username :");
        username = s.nextLine();

        System.out.println("Enter Password :");
        password = s.nextLine();

        if (username.equals(Username) && password.equals(Password)) {
            System.out.println("\nAccess granted \nWelcome to admin console of Recruitment Department\n");
            return true;
        } else {
            System.out.println("Invalid Credentials");
            return false;
        }
    }
}