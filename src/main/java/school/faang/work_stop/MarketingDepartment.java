package school.faang.work_stop;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        System.out.println("Reading file Design");
        List<String> fileDesign = designResources.readeDesign();

        System.out.println("Added File Design from Marketing");
        marketingResources.addFileMarketing("Marketing add");
    }
}
