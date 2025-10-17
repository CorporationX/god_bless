package school.faang.bjs2_93296;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    @Override
    public void run() {
        for (String word : marketingResources.getFilesMarketing()) {
            designResources.addFile(word);
        }
    }
}
