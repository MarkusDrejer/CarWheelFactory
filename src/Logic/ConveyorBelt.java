package Logic;

import Data.DataContainer;
import Model.IWheel;

public class ConveyorBelt implements Runnable {

    private String name;
    private int wheelsDone = 0;

    public ConveyorBelt(String name) {
        this.name = name;
    }

    public void run() {

        while (true) {
            try {
                IWheel currentWheel = DataContainer.remove();

                if(currentWheel == null) {
                    Thread.sleep(10);
                } else {
                    System.out.println("Commencing work on a " + currentWheel.getName() + " on belt: " + name);
                    Thread.sleep(currentWheel.getAssemblyTime());
                    System.out.println("A " + currentWheel.getName() + " is done on belt: " + name);
                    System.out.println("Belt: " + name + " has completed: " + ++wheelsDone + " wheels");

                    if ((wheelsDone % 10) == 0) {
                        System.out.println("Belt: " + name + " is being cleaned");
                        Thread.sleep(6000);
                        System.out.println("Belt: " + name + " has finished being cleaned");
                    }

                    System.out.println("Preparing for next run on belt: " + name);
                    Thread.sleep(2000);
                    System.out.println("Ready for next run on belt: " + name);

                    System.out.println("Items left: " + DataContainer.left());
                }

            } catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}