package Concurrency_4;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {

    private String writeLock = "writeLock";

    private int count = 1;

    private List<String> list = new ArrayList<>();

    public void outPutFile(MarketingResources marketingResources) {
        synchronized (marketingResources.getReadLock()) {
            System.out.println("Start output design resources");
            for (String string : list) {
                System.out.println(string);
            }
            System.out.println("End output design resources");
            marketingResources.addForList("MarketingResources file " + count++, this);
        }
    }

    public void addForList(String string) {
        synchronized (writeLock) {
            list.add(string);
            System.out.println("in DesignResources added " + string);
        }
    }

    public List<String> getList() {
        return list;
    }

    public String getWriteLock() {
        return writeLock;
    }
}
