package Visual;

import Logic.ConveyorBelt;
import Data.DataContainer;
import Model.HighEnd;
import Model.Normal;
import Model.Winter;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UI {

    private static final int MAX_T = 4;
    private ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
    private Scanner console = new Scanner(System.in);

    public UI() {
        run();
    }

    private void run() {
        for (int i = 1; i <= MAX_T; i++) {
            Runnable CB = new ConveyorBelt("Belt " + i, i);
            pool.execute(CB);
        }

        while(true) {
            System.out.println("1. Normal car wheel \n" +
                    "2. Winter car wheel \n" +
                    "3. High quality car wheel");
            int wheelType = console.nextInt();
            System.out.println("Input amount");
            int wheelAmount = console.nextInt();

            for(int i = 0; i < wheelAmount; i++) {
                switch (wheelType) {
                    case 1:
                        DataContainer.wheelQueue.add(new Normal());
                        break;
                    case 2:
                        DataContainer.wheelQueue.add(new Winter());
                        break;
                    case 3:
                        DataContainer.wheelQueue.add(new HighEnd());
                        break;
                }
            }
        }
    }
}