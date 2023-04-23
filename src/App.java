import java.util.Scanner;

import models.enums.CommandEnum;
import utils.*;
import exceptions.*;
import controllers.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            CommandUtil.show_command_menu();
            System.out.println();
            System.out.println("\nPlease enter the command - \n");
            String user_command = scanner.next();
            try {
                CommandEnum input_command = CommandUtil.validate_user_command(user_command);
                if (input_command == null) {
                    throw new InvalidCommandException("\nInvaid command : " + user_command + "\n Please enter valid command");
                }
                String response = DelegateCommand.delegate_to_service(input_command);
                System.out.println(response);
            }
            catch (InvalidUserException invalidUserException) {
                System.out.println(invalidUserException.getMessage());
                //invalidUserException.printStackTrace();
            }
            catch (NoUserLoggedInException noUserLoggedInException) {
                System.out.println(noUserLoggedInException.getMessage());
                //noUserLoggedInException.printStackTrace();
            }
            catch (InvalidCommandException invalidCommandException) {
                System.out.println(invalidCommandException.getMessage());;
                //invalidComandException.printStackTrace();
            }
            System.out.println();
        }
    }
}
