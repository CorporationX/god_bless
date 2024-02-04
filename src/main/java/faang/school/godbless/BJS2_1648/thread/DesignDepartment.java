package faang.school.godbless.BJS2_1648.thread;

import faang.school.godbless.BJS2_1648.resources.DesignResources;
import faang.school.godbless.BJS2_1648.resources.MarketingResources;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesignDepartment extends Thread {
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        synchronized (marketingResources) {
            System.out.println("From design department: Files from marketing resources " + marketingResources.getFiles());
            synchronized (designResources) {
                designResources.addFile("File added from design department");
            }
        }
        System.out.println("design department completed its task");
    }
}
