package school.faang.workSuspended.Fixed;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MarketingDepartment implements Runnable {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        System.out.println("Marketing Department is reading design files...");
        List<String> designFiles = designResources.getDesignFiles();
        System.out.println("Marketing Department is adding design files to marketing files...");
        for (String file : designFiles) {
            marketingResources.addFile(file);
        }
    }
}