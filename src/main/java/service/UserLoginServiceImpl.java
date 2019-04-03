package service;

import constant.Config;
import model.UserCredentials;
import reader.ReadFromFile;

import java.util.Iterator;
import java.util.List;

public class UserLoginServiceImpl {

    public static Boolean userLogIn(String username, String password) {

        List<UserCredentials> allUsers = ReadFromFile.getInstance().readUsersFromFile(Config.USER_PASSWORDS_FILE);
        boolean userOk = false;

        Iterator<UserCredentials> usersIterator = allUsers.iterator();
        while (!userOk && usersIterator.hasNext()) {
            UserCredentials userCredentials = usersIterator.next();
            if (userCredentials.getUserName().equals(username) && userCredentials.getPassword().equals(password)) {
                userOk = true;
            }
        }
        return userOk;
    }
}

