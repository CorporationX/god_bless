package school.faang.task423.department;

import lombok.AllArgsConstructor;
import school.faang.task423.resources.DesignResources;
import school.faang.task423.resources.MarketingResources;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> files = new ArrayList<>(designResources.getFiles());
        files.forEach(marketingResources::addFile);
    }
}
