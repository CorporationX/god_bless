package faang.school.godbless.deadlock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DesignDepartment extends Thread {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    private void work() {
        synchronized (designResources) {
            designResources.writeFiles("Design department started working");
            synchronized (marketingResources) {
                marketingResources.readFiles();
            }
            designResources.writeFiles("Design department adding files" +
                    " after looking at marketing resources");
        }
    }

    @Override
    public void run() {
        work();
    }
}
