package controllers;

import models.enums.CommandEnum;
import exceptions.*;
import services.CommandService;

public class DelegateCommand {
    public static String delegate_to_service(CommandEnum command) throws InvalidUserException, NoUserLoggedInException{
        CommandService commandService = new CommandService();
        
        switch(command) {
            case SIGNUP:
                return commandService.signup_user();
            case LOGIN:
                return commandService.login_user();
            case LOGOUT:
                return commandService.logout_user();
            /*case POST:
                return "Service not available currently :p";
            case FOLLOW:
                return "Service not available currently :p";
            case REPLY:
                return "Service not available currently :p";
            case UPVOTE:
                return "Service not available currently :p";
            case DOWNVOTE:
                return "Service not available currently :p";
            case SHOWNEWSFEED:
                return "Service not available currently :p";
            */
            default :
                return null;
        }
    }
}
