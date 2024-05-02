package vn.viettuts.detaiso10.entity;

public class User {

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
