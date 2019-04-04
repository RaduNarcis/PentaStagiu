package commons;

public enum AccountType {

    RON("RON"),
    EUR("EUR");

    public String value;

    AccountType(String value) {
        this.value = value;
    }
}
