package faang.school.godbless.workstop.taskone;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DesignDepartment extends Thread{

    DesignResources designResources;
    MarketingResources marketingResources;

    @Override
    public void run() {
        synchronized (designResources.getNames()) {
            sleep(3);
            List<String> names = marketingResources.getNames();
            designResources.addName(names.get(0));
        }
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
