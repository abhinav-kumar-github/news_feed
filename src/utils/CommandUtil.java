package utils;

import models.enums.CommandEnum;

public class CommandUtil {
    public static CommandEnum validate_user_command(String user_command) {
        for(CommandEnum command : CommandEnum.values()) {
            if (user_command.toUpperCase().compareTo(command.toString()) == 0) {
                return command;
            }
        }
        return null;
    }

    public static void show_command_menu() {
        System.out.println("\nCommands available : \n");
        for(CommandEnum command : CommandEnum.values()) {
            System.out.print("* " + command + "\t\t");
        }
        System.out.println();
    }
}
