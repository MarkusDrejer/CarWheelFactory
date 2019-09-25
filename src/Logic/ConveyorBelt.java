package Logic;

import Data.DataContainer;
import Model.Wheel;

public class ConveyorBelt implements Runnable {

    private String name;
    private int assemblyTime;
    private int offset;
    private int wheelsDone = 0;

    public ConveyorBelt(String name, int offset) {
        this.name = name;
        this.offset = offset;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(offset);

                if (DataContainer.wheelQueue.isEmpty()) {
                    Thread.sleep(1000);
                } else {

                    Wheel currentWheel = DataContainer.wheelQueue.poll();

                        switch (currentWheel.getType()) {
                            case 1:
                                assemblyTime = 10000;
                                break;
                            case 2:
                                assemblyTime = 14000;
                                break;
                            case 3:
                                assemblyTime = 17000;
                                break;
                        }

                        System.out.println("Commencing work on belt: " + name);
                        Thread.sleep(assemblyTime);
                        System.out.println("Wheel is done on belt: " + name);
                        System.out.println("Belt: " + name + " has completed: " + ++wheelsDone + " wheels");

                        if((wheelsDone % 10) == 0) {
                            System.out.println("Belt: " + name + " is being cleaned");
                            Thread.sleep(6000);
                            System.out.println("Belt: " + name + " has finished being cleaned");
                        }

                        System.out.println("Preparing for next run on belt: " + name);
                        Thread.sleep(2000);
                        System.out.println("Ready for next run on belt: " + name);
                }

            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
