package Concurrency_4;

public class DesignDepartment implements Runnable {

    @Override
    public void run() {
        MarketingResources.outPutFile();
    }
}
