package ua.training.controller;

import java.util.Scanner;
import ua.training.model.Model;
import ua.training.model.View;
import ua.training.model.ExistedLoginException;

public class Controller {
    // Constructor
    private Model model;
    private View view;
    public boolean succes;
    public boolean isSucces(){
        return succes;
    }
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
        succes = false;
    }

    // The Work method
    public String processUser(String name, String login){
        boolean correct;
        if (name.matches(Constants.NAME_REG_EX)){
            model.setName(name);
        } else {
            succes = false;
            return  View.SORRY_CAN_YOU_TRY_AGAIN + "\n" +
                    View.YOUR_INPUT_SHOULD_MATCHES + Constants.NAME_REG_EX + "\n" +
                    View.INPUT_YOUR + View.NAME + "\n";
        }

        if (login.matches(Constants.LOGIN_REG_EX)){
            try{
                model.setLogin(login);
            } catch (ExistedLoginException ex) {
                return ex.getMessage();
            } finally {
                succes = true;
            }
        } else {
            succes = false;
            return  View.SORRY_CAN_YOU_TRY_AGAIN + "\n" +
                    View.YOUR_INPUT_SHOULD_MATCHES + Constants.LOGIN_REG_EX + "\n" +
                    View.INPUT_YOUR + View.LOGIN + "\n";
        }
        return View.SUCCESS;
    }

    // The Utility methods
    private String inputRegExStringWithScanner(String RegEx, String fieldName, Scanner sc){
        view.printMessage(View.INPUT_YOUR, fieldName);
        String line = sc.nextLine();

        while (!line.matches(RegEx)) {
            view.printMessage(View.SORRY_CAN_YOU_TRY_AGAIN);
            view.printMessage(View.YOUR_INPUT_SHOULD_MATCHES, RegEx);
            view.printMessage(View.INPUT_YOUR, fieldName);
            line = sc.nextLine();
        }
        return line;
    }
}
