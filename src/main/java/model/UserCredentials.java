package model;

import java.util.Objects;

public class UserCredentials {

    private String userName;
    private String password;

    public UserCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "model.UserCredentials{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCredentials)) return false;
        UserCredentials userName1 = (UserCredentials) o;
        return Objects.equals(getUserName(), userName1.getUserName()) &&
                Objects.equals(getPassword(), userName1.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword());
    }
}
