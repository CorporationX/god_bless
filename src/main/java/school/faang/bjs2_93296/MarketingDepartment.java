package school.faang.bjs2_93296;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    @Override
    public void run() {
        for (String word : designResources.getFilesDesign()) {
            marketingResources.addFile(word);
        }
    }
}
