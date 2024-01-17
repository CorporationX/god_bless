package Concurrency_4;

import java.util.ArrayList;
import java.util.List;

public class MarketingResources {

    private String readLock = "readLock";

    private int count = 1;

    private List<String> list = new ArrayList<>();

    public void outPutFile(DesignResources designResources) {
        synchronized (readLock) {
            System.out.println("Start output marketing resources");
            for (String string : list) {
                System.out.println(string);
            }
            System.out.println("End output marketing resources");
            designResources.addForList("DesignResources file " + count++);
        }
    }

    public void addForList(String string, DesignResources designResources) {
        synchronized (designResources.getWriteLock()) {
            list.add(string);
            System.out.println("in MarketingResources added " + string);
        }
    }

    public List<String> getList() {
        return list;
    }

    public String getReadLock() {
        return readLock;
    }
}
