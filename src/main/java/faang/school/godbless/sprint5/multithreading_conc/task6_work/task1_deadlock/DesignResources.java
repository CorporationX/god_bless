package faang.school.godbless.sprint5.multithreading_conc.task6_work.task1_deadlock;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class DesignResources {

    @Getter
    private List<String> files = new ArrayList<>();

    private List<String> filesFromMarketingResources = new ArrayList<>();

    private MarketingResources marketingResources;

    public void addMarketingResources(MarketingResources marketingResources) {
        this.marketingResources = marketingResources;
    }

    @SneakyThrows
    public void addFilesFromMarketingResources() {
        synchronized (marketingResources.getFiles()) {
            Thread.sleep(1000);
            synchronized (files) {
                files.addAll(marketingResources.getFiles());
                System.out.println("All files added to design resources");
            }
        }
    }

    public void addFile(String file) {
        synchronized (files) {
            files.addAll(filesFromMarketingResources);
            System.out.println("added file: " + file + " to design resources");
        }
    }
}
