package service.user;

import configuration.Config;
import model.UserCredentials;
import reader.ReadFromFile;

import java.util.Iterator;
import java.util.List;

public class UserLoginServiceImpl {

    public static UserCredentials userLogIn(String username, String password) {

        List<UserCredentials> allUsers = ReadFromFile.getInstance().readUsersFromFile(Config.USER_PASSWORDS_FILE);
        UserCredentials foundUser = null;

        Iterator<UserCredentials> usersIterator = allUsers.iterator();
        while (foundUser == null && usersIterator.hasNext()) {
            UserCredentials userCredentials = usersIterator.next();
            if (userCredentials.getUserName().equals(username) && userCredentials.getPassword().equals(password)) {
                foundUser = userCredentials;
            }
        }
        return foundUser;
    }
}