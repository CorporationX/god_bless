package faang.school.godbless.work_stands;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class DesignDepartment implements Runnable {
    private final DesignResources designResources = new DesignResources();
    private MarketingDepartment marketingDepartment;

    @Override
    public void run() {
        designResources.addFile("Design file");
        log.info("Design Started Working");

        designResources.addFile(marketingDepartment.getMarketingResources().readFiles().get(0));

        System.out.println(designResources);
    }
}
