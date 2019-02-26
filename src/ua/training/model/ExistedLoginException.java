package ua.training.model;

public class ExistedLoginException extends Exception{
    public ExistedLoginException(String message){
        super(message);
    }
}
