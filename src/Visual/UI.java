package Visual;

import Model.ConveyorBelt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UI {

    private static final int MAX_T = 4;
    private ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

    public UI() {
        run();
    }

    private void run() {
        for (int i = 1; i <= MAX_T; i++) {
            Runnable CB = new ConveyorBelt("Belt " + i);
            pool.execute(CB);
        }

    }
}