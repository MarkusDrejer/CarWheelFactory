package Model;

public class ConveyorBelt implements Runnable {

    private String name;
    private int assemblyTime;
    private int offset;

    public ConveyorBelt(String name, int offset) {
        this.name = name;
        this.offset = offset;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(offset);

                if (DataContainer.wheelQueue.peek() == null) {
                    Thread.sleep(1000);
                } else {

                    Wheel currentWheel = DataContainer.wheelQueue.poll();

                    synchronized (currentWheel) {

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
                        System.out.println("Wheel is done");
                        System.out.println("Preparing for next run");
                        Thread.sleep(2000);
                        System.out.println("Ready for next run");

                    }
                }

            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
