package reader;

import model.UserCredentials;
import service.UserLoginService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class UserFileReader {

    private final static Logger logger = Logger.getLogger(UserFileReader.class.getName());

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

    /**
     * read users and passwords
     * @param path
     * @return
     */
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
            logger.info("Exception!");
        } catch (Exception e2) {
            logger.warning("Exception!");
        }
        return allUserCredentials;
    }
}
