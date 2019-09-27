package Data;

import Model.IWheel;

import java.util.LinkedList;
import java.util.Queue;

public class DataContainer {

    public static volatile Queue<IWheel> wheelQueue = new LinkedList<>();

    public synchronized static IWheel remove() {
        return wheelQueue.poll();
    }

    public synchronized static boolean checkEmpty() {
        return wheelQueue.isEmpty();
    }
}
