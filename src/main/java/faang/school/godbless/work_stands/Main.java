package faang.school.godbless.work_stands;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        MarketingDepartment marketingDepartment = new MarketingDepartment();
        DesignDepartment designDepartment = new DesignDepartment();

        marketingDepartment.setDesignDepartment(designDepartment);
        designDepartment.setMarketingDepartment(marketingDepartment);

        Thread marketingWork = new Thread(marketingDepartment);
        Thread designWork = new Thread(designDepartment);

        marketingWork.start();
        designWork.start();

        try {
            marketingWork.join();
            designWork.join();
            log.info("Work is finished");
        } catch (InterruptedException e) {
            throw new RuntimeException("Program was interrupted: " + e.getMessage());
        }
    }
}
