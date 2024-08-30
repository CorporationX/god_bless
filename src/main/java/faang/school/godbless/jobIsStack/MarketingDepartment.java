package faang.school.godbless.jobIsStack;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MarketingDepartment extends Thread {

    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    private void doWork() {
        System.out.println("MarketingDepartment start working with marketingResources");
        marketingResources.addNewFile("Marketing v 1.0");
        marketingResources.readAllFiles();
        System.out.println("MarketingDepartment start working with designResources");
        designResources.readAllFiles();
        System.out.println("MarketingDepartment finish working with designResources");
        System.out.println("MarketingDepartment stop working");
    }

    @Override
    public void run() {
        doWork();
    }
}
