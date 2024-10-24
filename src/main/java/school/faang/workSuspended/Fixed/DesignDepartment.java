package school.faang.workSuspended.Fixed;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DesignDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        System.out.println("Design Department is reading marketing files...");
        List<String> marketingFiles = marketingResources.getMarketingFiles();
        System.out.println("Design Department is adding marketing files to design files...");
        for (String file : marketingFiles) {
            designResources.addFile(file);
        }
    }
}
