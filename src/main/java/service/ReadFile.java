package service;

import java.io.File;
import java.io.FileReader;

public class ReadFile {

    private static ReadFile instance = null;

    private ReadFile() {

    }

    public static ReadFile getInstance() {
        if (instance == null) {
            instance = new ReadFile();
        }
        return instance;
    }

    /*
    public void readFromFile(){
        File file = new File(getClass().getClassLoader().getResource("UserPass.txt").getFile());

    }
    */
}
