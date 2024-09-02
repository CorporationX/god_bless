package work.waiting.departments;

import lombok.NonNull;
import work.waiting.Main;
import work.waiting.departments.resources.Resources;

public class DesignDepartment extends ThreadDepartment {
    public DesignDepartment(@NonNull Resources marketingResources,
                            @NonNull Resources designResources) {
        super(marketingResources, designResources);
    }

    @Override
    public void run() {
        for (int i = 0; i < Main.FILES_COUNT; i++) {
            String file = marketingResources.getFile();
            designResources.addFile(file);
        }
    }
}
