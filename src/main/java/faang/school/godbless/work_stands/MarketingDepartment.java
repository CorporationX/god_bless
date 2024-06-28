package faang.school.godbless.work_stands;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources = new MarketingResources();
    private DesignDepartment designDepartment;

    @Override
    public void run() {
        synchronized (marketingResources) {
            log.info("Marketing Started Working");

            try {
                Thread.sleep(1000L);
                marketingResources.addFile("Marketing file");
                System.out.println(marketingResources);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.info("Trying to read Design files");
            List<String> marketingDepartmentFiles = designDepartment.getDesignResources().readFiles();
            log.info("Got design files");
            System.out.println(marketingDepartmentFiles);
        }
    }
}
