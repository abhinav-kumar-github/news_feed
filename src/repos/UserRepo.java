package repos;

import java.util.HashMap;
import models.User;

public class UserRepo {
    private static HashMap<String, User> data = new HashMap<>();

    public static HashMap<String, User> get_all_users() {
        return data;
    }

    public static User get_user_by_username(String username) {
        return data.getOrDefault(username, null);
    }

    public static void add_new_user(User user) {
        data.put(user.get_user_name(), new User(user.get_user_name(), user.get_password()));
    }
}
