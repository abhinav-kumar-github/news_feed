package services;

import java.util.Scanner;

import models.*;
import repos.*;
import exceptions.*;

public class CommandService {
    private Scanner sc = new Scanner(System.in);
    public static String current_user = null;

    public String signup_user() {
        if(current_user != null) {
            return "\nUser \"" + current_user + "\" is logged in.\n Please logout first\n";
        }
        System.out.println("\nEnter Username : ");
        String username = sc.next();
        if (UserRepo.get_user_by_username(username) != null){
            return "\nUser already Exist\n";
        }
        System.out.println("\nEnter Passsword : ");
        String password = sc.next();
        UserRepo.add_new_user(new User(username, password));
        current_user = username;
        return "\nSuccessfully created new user \"" + username + "\"";
    }

    public String login_user() throws InvalidUserException {
        System.out.println("\nEnter Username : ");
        String username = sc.next();
        if(current_user != null) {
            if (username.compareTo(current_user) != 0) {
                return "\nUser \"" + current_user + "\" is logged in.\n Please logout first\n";
            }
            else {
                return "\nUser \"" + current_user + "\" is already logged in.";
            }
        }
        if (UserRepo.get_user_by_username(username) != null) {
            User user_db_details = UserRepo.get_user_by_username(username);
            System.out.println("\nEnter Passsword : ");
            String password = sc.next();
            String user_password = user_db_details.get_password();
            if (password.compareTo(user_password) != 0) {
                return "\nWrong credentials\n Please enter correct password for user \"" + username + "\"\n";
            }
            current_user = username;
            return "\n" + username + " logged in successfully\n";
        }
        else throw new InvalidUserException("\nUser \"" + username + "\" does not exist\n");
    }

    public String logout_user() throws NoUserLoggedInException {
        if (current_user == null) {
            throw new NoUserLoggedInException("\n No user is currently logged in, Can't logout\n"); 
        }
        String temp_user = current_user;
        current_user = null;
        return "\n\"" + temp_user + "\"" + " logged out successfully\n";
    }
}
