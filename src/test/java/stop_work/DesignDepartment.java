package stop_work;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DesignDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    public DesignDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        System.out.println("DesignDepartment: Accessing MarketingResources for research..");
        marketingResources.printFilesNames();
        designResources.addFilesNames("Design_Draft.psd");
    }
}
