package logic;

import constant.Config;
import model.UserCredentials;
import reader.ReadFromFile;

import java.util.List;

public class UserUtil {

    private UserHolder holder = new UserHolder();

    private ReadFromFile userFileReader = ReadFromFile.getInstance();

    public UserUtil() {
        holder.setAllUsers(userFileReader.readUsersFromFile(Config.USER_PASSWORDS_FILE));
    }

    public UserCredentials find(String name) {
        return holder.getUser(name);
    }

    public List<UserCredentials> findAll() {
        return holder.getAllUsers();
    }
}
