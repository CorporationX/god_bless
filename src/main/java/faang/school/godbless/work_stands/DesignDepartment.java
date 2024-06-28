package faang.school.godbless.work_stands;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
public class DesignDepartment implements Runnable {
    private final DesignResources designResources = new DesignResources();
    private MarketingDepartment marketingDepartment;

    @Override
    public void run() {
        synchronized (designResources) {
            log.info("Design Started Working");

            try {
                Thread.sleep(1000L);
                designResources.addFile("Design file");
                System.out.println(designResources);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.info("Trying to read Marketing files");
            List<String> marketingDepartmentFiles = marketingDepartment.getMarketingResources().readFiles();
            log.info("Got marketing files");
            System.out.println(marketingDepartmentFiles);
        }
    }
}
