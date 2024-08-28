package faang.school.godbless.deadlock;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketingDepartment extends Thread {
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    private void work() {
        synchronized (marketingResources) {
            marketingResources.writeFiles("Marketing department starting working");
            synchronized (designResources) {
                designResources.readFiles();
            }
            marketingResources.writeFiles("Marketing department adding files" +
                    " after looking at design resources");
        }
    }

    @Override
    public void run() {
        work();
    }
}
