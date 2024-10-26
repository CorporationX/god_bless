package school.faang.work_stopped_BJS2_39304;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> designFiles = designResources.getFiles();
        marketingResources.addFile("Marketing Data.txt");
    }
}