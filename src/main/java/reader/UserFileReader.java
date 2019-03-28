package reader;

import model.UserCredentials;
import service.UserLoginService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class UserFileReader {

    private static String USER_CREDENTIALS_SEPARATOR = "   ";

    private static UserFileReader instance = null;

    private UserFileReader() {

    }

    public static UserFileReader getInstance() {
        if (instance == null) {
            instance = new UserFileReader();
        }
        return instance;
    }

    /*
     *
     * rolul metodei este sa citeasca userii si parolele din fisier
     * */
    public List<UserCredentials> readUsersFromFile(String path) {
        List<UserCredentials> allUserCredentials = new LinkedList<>();
        File file = new File(UserLoginService.class.getClassLoader().getResource(path).getFile());

        try (FileReader f = new FileReader(file);
             BufferedReader br = new BufferedReader(f)) {

            String line;
            String[] split;
            while ((line = br.readLine()) != null) {

                split = line.split(USER_CREDENTIALS_SEPARATOR);

                if (split.length == 2) {
                    UserCredentials userCredentials = new UserCredentials(split[0], split[1]);
                    allUserCredentials.add(userCredentials);
                }
            }

        } catch (FileNotFoundException e1) {
            // trebuie pus logger
            e1.printStackTrace();
        } catch (Exception e2) {
            // trebuie pus logger
            e2.printStackTrace();
        }
        return allUserCredentials;
    }
}
