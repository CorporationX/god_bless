package faang.school.godbless.sprint4.work;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesignDepartment extends Thread {
    private MarketingResources resources;
    private DesignResources designResources;

    public void run() {
        try {
            if (designResources.enter()) {
                designResources.viewFiles();
                designResources.addFile("newDesign.txt");
                if (resources.enter()) {
                    resources.addFile("newMarketing.txt");
                    resources.release();
                }
                designResources.release();
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
