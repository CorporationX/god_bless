package Concurrency_4;

public class MarketingDepartment implements Runnable {

    @Override
    public void run() {
        DesignResources.outPutFile();
    }
}
