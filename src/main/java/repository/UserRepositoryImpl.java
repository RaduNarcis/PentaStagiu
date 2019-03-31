package repository;

import constant.Config;
import model.UserCredentials;
import reader.UserFileReader;

import java.util.List;

public class UserRepositoryImpl {

    private UserHolder holder = new UserHolder();

    private UserFileReader userFileReader = UserFileReader.getInstance();

    public UserRepositoryImpl() {
        holder.setAllUsers(userFileReader.readUsersFromFile(Config.USER_PASSWORDS_FILE));
    }

    public UserCredentials find(String name) {
        return holder.getUser(name);
    }

    public List<UserCredentials> findAll() {
        return holder.getAllUsers();
    }
}
