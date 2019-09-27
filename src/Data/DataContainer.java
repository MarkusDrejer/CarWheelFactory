package Data;

import Model.IWheel;

import java.util.LinkedList;
import java.util.Queue;

public class DataContainer {

    private static volatile Queue<IWheel> wheelQueue = new LinkedList<>();

    public static void addToList(IWheel wheel) {
        wheelQueue.add(wheel);
    }

    //Synchronized methods to avoid several Threads reading the same item(s)
    public synchronized static IWheel remove() {
        return wheelQueue.poll();
    }

    public synchronized static int left() {
        return wheelQueue.size();
    }
}