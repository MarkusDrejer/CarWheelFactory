package Data;

import Model.IWheel;

import java.util.LinkedList;
import java.util.Queue;

public class DataContainer {

    private static volatile Queue<IWheel> wheelQueue = new LinkedList<>();

    public static void addToList(IWheel wheel) {
        wheelQueue.add(wheel);
    }

    public synchronized static IWheel remove() {
        return wheelQueue.poll();
    }

    public synchronized static int left() {
        return wheelQueue.size();
    }
}