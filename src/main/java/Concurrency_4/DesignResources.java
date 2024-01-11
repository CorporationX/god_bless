package Concurrency_4;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {

    private static String writeLock = "writeLock";

    private static int count = 1;

    private static List<String> list = new ArrayList<>();

    public static void outPutFile() {
        synchronized (MarketingResources.getReadLock()) {
            System.out.println("Start output design resources");
            for (String string : list) {
                System.out.println(string);
            }
            System.out.println("End output design resources");
            MarketingResources.addForList("MarketingResources file " + count++);
        }
    }

    public static void addForList(String string) {
        synchronized (writeLock) {
            list.add(string);
            System.out.println("in DesignResources added " + string);
        }
    }

    public static List<String> getList() {
        return list;
    }

    public static String getWriteLock() {
        return writeLock;
    }
}
