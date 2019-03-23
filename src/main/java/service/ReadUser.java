package service;

import view.GeneralView;
import view.MyView;
import view.UserLogInView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadUser {

    UserLogInView userLogInView = new UserLogInView();
    GeneralView generalView = new GeneralView();

    public static void userLogIn() {

        String filePath = "C:\\Users\\Dell\\PentaStagiu\\src\\main\\resources\\UserPass.txt";
        String userInput;
        File file = new File(filePath);

        try (FileReader f = new FileReader(file);
             BufferedReader br = new BufferedReader(f)) {

            Scanner scanner = new Scanner(System.in);
            String[] split;

            while ((userInput = br.readLine()) != null) {

                boolean done = false;
                while (!done) {

                    split = userInput.split("   ");
                    System.out.println("Please enter username: ");
                    String userName = scanner.nextLine();

                    System.out.println("Enter password: ");
                    String userPassword = scanner.nextLine();

                    if (userName.equals(split[0]) && userPassword.equals(split[1])) {
                        System.out.println("Welcome " + userName);
                        done = true;
                        new UserLogInView().displayOptions();
                    } else {
                        System.out.println("Invalid");
                        System.exit(0);
                    }
                }
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();

        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void userLogOut() {
        System.out.println("Succesfully logged out");
        new GeneralView().displayOptions();
    }
}

