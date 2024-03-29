package Visual;

import Logic.ConveyorBelt;
import Logic.QueueFiller;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UI {

    private static final int MAX_T = 4;
    private ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
    private Scanner console = new Scanner(System.in);
    private QueueFiller queueFiller = new QueueFiller();

    public UI() {
        startProgram();
    }

    private void startProgram() {
        for (int i = 1; i <= MAX_T; i++) {
            Runnable CB = new ConveyorBelt("Belt " + i);
            pool.execute(CB);
        }

        while(true) {
            System.out.println("1. Normal car wheel \n" +
                                "2. Winter car wheel \n" +
                                 "3. High quality car wheel");
            int wheelType = console.nextInt();
            System.out.println("Input amount");
            int wheelAmount = console.nextInt();

            queueFiller.addToData(wheelType, wheelAmount);
        }
    }
}