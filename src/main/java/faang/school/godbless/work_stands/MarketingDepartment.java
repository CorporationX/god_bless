package faang.school.godbless.work_stands;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources = new MarketingResources();
    private DesignDepartment designDepartment;

    @Override
    public void run() {
        marketingResources.addFile("Marketing file");
        log.info("Marketing Started Working");

        marketingResources.addFile(designDepartment.getDesignResources().readFiles().get(0));

        System.out.println(marketingResources);
    }
}
