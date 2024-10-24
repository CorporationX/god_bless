package school.faang.workSuspended.Deadlock;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        synchronized (marketingResources) {
            System.out.println("Design Department is reading marketing files...");
            List<String> marketingFiles = marketingResources.getMarketingFiles();
            synchronized (designResources) {
                System.out.println("Design Department is adding marketing files to design files...");
                for (String file : marketingFiles) {
                    designResources.addFile(file);
                }
            }
        }
    }
}
