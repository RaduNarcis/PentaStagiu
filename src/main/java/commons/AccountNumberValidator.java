package commons;

public class AccountNumberValidator {

    public static boolean validateIBAN(String iban){
        if(iban != null && iban.length() == 24) {
            return true;
        }
        return false;
    }
}
