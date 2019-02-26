package ua.training.model;

public class View {
    // Text's constants
    public static final String SUCCESS = "succes, now you can try again";
    public static final String INPUT_YOUR = "Input Your ";

    public static final String NAME = "name = ";
    public static final String LOGIN = "login = ";

    public static final String SORRY_CAN_YOU_TRY_AGAIN = "Sorry, can you try again?";
    public static final String YOUR_INPUT_SHOULD_MATCHES = "Your Input should matches -> ";
    public static final String LOGIN_ALREADY_EXIST = "sorry, this login has already been taken";

    public void printMessage(String... messages){
        for (String message : messages){
            System.out.print(message);
        }
        System.out.print("\n");
    }
}
