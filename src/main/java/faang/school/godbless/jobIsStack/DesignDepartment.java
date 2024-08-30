package faang.school.godbless.jobIsStack;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DesignDepartment extends Thread {

    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    private void doWork() {
        synchronized (designResources) {
            System.out.println("Design department start working with design resources");
            designResources.addNewFile("Design v1.0");
            designResources.readAllFiles();
            synchronized (marketingResources) {
                System.out.println("Design department start working with marketing resources");
                marketingResources.readAllFiles();
            }
            System.out.println("Design department stop working");
        }
    }

    @Override
    public void run() {
        doWork();
    }
}
