package Main;

import Features.Application;

import javax.naming.LimitExceededException;

public class Main {

    public static void main(String[] args) throws LimitExceededException {
        Application runApp = new Application();
        runApp.runApp();
    }
}
