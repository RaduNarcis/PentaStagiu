package service.user;

import configuration.Config;
import model.UserCredentials;
import reader.ReadFromFile;

import java.util.List;

public class UserService {

    private UserHolder holder = new UserHolder();

    private ReadFromFile userFileReader = ReadFromFile.getInstance();

    public UserService() {
        holder.setAllUsers(userFileReader.readUsersFromFile(Config.USER_PASSWORDS_FILE));
    }

    public UserCredentials find(String name) {
        return holder.getUser(name);
    }

    public List<UserCredentials> findAll() {
        return holder.getAllUsers();
    }
}
