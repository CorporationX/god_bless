package school.faang.work_stopped_BJS2_39304;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    @Override
    public void run() {
        List<String> marketingFiles = marketingResources.getFiles();
        designResources.addFile("Design Data.txt");
    }
}