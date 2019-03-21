public class Main {

    public static void main(String[] args) {

        String filePath = "UserPass.txt";

        try{
            ReadUser.readUsers(filePath);
        } catch (Exception e){
            e.printStackTrace();
        }

        Menu m1 = new Menu();
        m1.displayMenu();
    }
}
