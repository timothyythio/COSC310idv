package Main;

import Features.Application;

import javax.naming.LimitExceededException;

public class MainStopper {

    public static void main(String[] args) throws LimitExceededException {
        start();
    }
    
    public static void start() {
    	
    	Application runApp = new Application();
        runApp.runApp();
    	
    }
}

