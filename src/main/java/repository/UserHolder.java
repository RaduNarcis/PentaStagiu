package repository;

import model.UserCredentials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserHolder {

    private Map<String, UserCredentials> users = new HashMap<String, UserCredentials>();

    public void setAllUsers(List<UserCredentials> users) {
        for (UserCredentials userCredentials : users) {
            this.users.put(userCredentials.getUserName(),userCredentials);

        }
    }

    public UserCredentials getUser(String name){
        return this.users.get(name);

    }

    public List<UserCredentials> getAllUsers(){
        return new ArrayList<UserCredentials>(this.users.values());

    }
}

