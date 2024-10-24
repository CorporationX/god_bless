package school.faang.workSuspended.Deadlock;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MarketingDepartment implements Runnable{
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (designResources) {
            System.out.println("Marketing Department is reading design files...");
            List<String> designFiles = designResources.getDesignFiles();
            synchronized (marketingResources) {
                System.out.println("Marketing Department is adding design files to marketing files...");
                for (String file : designFiles) {
                    marketingResources.addFile(file);
                }
            }
        }
    }
}
