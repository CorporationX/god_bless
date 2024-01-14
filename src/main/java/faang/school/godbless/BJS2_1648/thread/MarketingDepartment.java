package faang.school.godbless.BJS2_1648.thread;

import faang.school.godbless.BJS2_1648.resources.DesignResources;
import faang.school.godbless.BJS2_1648.resources.MarketingResources;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment extends Thread {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        synchronized (designResources) {
            System.out.println("From marketing department: Files from design resources " + designResources.getFiles());
            synchronized (marketingResources) {
                marketingResources.addFile("File added from marketing department");
            }
        }
        System.out.println("marketing department completed its task");
    }
}
