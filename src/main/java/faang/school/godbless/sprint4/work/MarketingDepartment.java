package faang.school.godbless.sprint4.work;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment extends Thread {
    private MarketingResources resources;
    private DesignResources designResources;

    public void run() {
        try {
            if (resources.enter()) {
                resources.viewFiles();
                resources.addFile("newAdvertising.txt");
                if (designResources.enter()) {
                    designResources.addFile("newDesign.txt");
                    designResources.release();
                }
                resources.release();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
