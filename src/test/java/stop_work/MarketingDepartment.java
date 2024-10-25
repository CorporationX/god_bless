package stop_work;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MarketingDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    public MarketingDepartment(DesignResources designResources, MarketingResources marketingResources) {
        this.designResources = designResources;
        this.marketingResources = marketingResources;
    }

    @Override
    public void run() {
        System.out.println("MarketingDepartment: Accessing DesignResources for analysis ");
        designResources.printFilesNames();
        marketingResources.addFilesNames("Marketing_Report.docx");
    }
}


