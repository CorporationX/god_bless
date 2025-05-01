package school.faang.work_stop;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (designResources) {
            System.out.println("Reading file Design");
            List<String> fileDesign = designResources.readeDesign();
            synchronized (marketingResources) {
                System.out.println("Added File Design from Marketing");
                marketingResources.addFileMarketing("Marketing add");
            }
        }
        /*
        Поменял местами объекты в синхронайз блоке чтобы избежать DeadLock,
        они оба сначала блокируются на DesignResources
        */
        synchronized (marketingResources) {
            System.out.println("Reading file Design");
            List<String> fileDesign = designResources.readeDesign();
            synchronized (designResources) {
                System.out.println("Added File Design from Marketing");
                marketingResources.addFileMarketing("Marketing add");
            }
        }
    }
}
