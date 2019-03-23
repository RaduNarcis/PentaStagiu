package view;

public interface MyView {

    public static final int EXIT_OPTION = 0;

    public void displayOptions();

    public int readOption();

    public void processOption(int option);
}
