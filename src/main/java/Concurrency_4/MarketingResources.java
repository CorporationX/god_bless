package Concurrency_4;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {

    private static String readLock = "readLock";

    private static int count = 1;

    private static List<String> list = new ArrayList<>();

    public static void outPutFile() {
        synchronized (readLock) {
            System.out.println("Start output marketing resources");
            for (String string : list) {
                System.out.println(string);
            }
            System.out.println("End output marketing resources");
            DesignResources.addForList("DesignResources file " + count++);
        }
    }

    public static synchronized void addForList(String string) {
        synchronized (DesignResources.getWriteLock()) {
            list.add(string);
            System.out.println("in MarketingResources added " + string);
        }
    }

    public static List<String> getList() {
        return list;
    }

    public static String getReadLock() {
        return readLock;
    }
}
