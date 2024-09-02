package work.waiting.departments;

import lombok.NonNull;
import work.waiting.Main;
import work.waiting.departments.resources.Resources;

public class MarketingDepartment extends ThreadDepartment {
    public MarketingDepartment(@NonNull Resources marketingResources,
                               @NonNull Resources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        for (int i = 0; i < Main.FILES_COUNT; i++) {
            String file = designResources.getFile();
            marketingResources.addFile(file);
        }
    }
}
