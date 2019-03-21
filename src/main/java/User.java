import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class User {

    public static void readUsers(String filePath) {

        try {
            File f = new File(filePath);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();

        } catch (Exception e2){
            e2.printStackTrace();

        }
    }
}
