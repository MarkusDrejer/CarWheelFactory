package Logic;

import Data.DataContainer;
import Model.IWheel;

import java.util.Random;

public class ConveyorBelt implements Runnable {

    private String name;
    private int wheelsDone;
    private Random rand = new Random();

    public ConveyorBelt(String name) {
        this.name = name;
    }

    public void run() {

        while (true) {
            try {
                //Synced between Threads so only 1 Thread will get the actual wheel and the others will get Null
                IWheel currentWheel = DataContainer.remove();
                int failChance = rand.nextInt(10);

                //Experimental Condition to not go into production with no wheel and hitting a NullPointerException
                //Can probably be improved
                if(currentWheel == null) {
                    Thread.sleep(10);
                } else if(failChance == 0) {
                    System.out.println("An error has occurred on belt: " + name);
                    System.out.println("Maintenance is being performed on belt: " + name);
                    Thread.sleep(10000);
                    System.out.println("Belt: " + name + " NOW READY FOR WORK");
                } else {

                //May be a way to handle "Workload" other than sleep
                    System.out.println("Commencing work on a " + currentWheel.getName() + " on belt: " + name);
                    Thread.sleep(currentWheel.getAssemblyTime());
                    System.out.println("A " + currentWheel.getName() + " is done on belt: " + name);
                    System.out.println("Belt: " + name + " has completed: " + ++wheelsDone + " wheel(s)");

                    if ((wheelsDone % 10) == 0) {
                        System.out.println("Belt: " + name + " is being cleaned");
                        Thread.sleep(6000);
                        System.out.println("Belt: " + name + " has finished being cleaned");
                    }

                    System.out.println("Preparing for next run on belt: " + name);
                    Thread.sleep(2000);
                    System.out.println("Ready for next run on belt: " + name);

                    System.out.println("Items left in queue: " + DataContainer.left());
                }

            } catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}