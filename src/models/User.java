package models;

public class User {
    private String user_name;
    private String password;
    
    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public String get_user_name() {
        return user_name;
    }

    public void set_user_name(String user_name) {
        this.user_name = user_name;
    }

    public String get_password() {
        return password;
    }

    public void set_password(String password) {
        this.password = password;
    }
}
