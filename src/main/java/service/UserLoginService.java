package service;

import constant.Config;
import model.UserCredentials;
import reader.UserFileReader;

import java.util.Iterator;
import java.util.List;

public class UserLoginService {

    public static Boolean userLogIn(String username, String password) {

        /*
         * citim toti userii din fisier
         * */
        List<UserCredentials> allUsers = UserFileReader.getInstance().readUsersFromFile(Config.USER_PASSWORDS_FILE);
        boolean userOk = false;
        // iteram prin useri si incercam sa vedem daca gasim userul si parola cautate
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

