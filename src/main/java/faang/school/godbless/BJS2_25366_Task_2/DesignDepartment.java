package faang.school.godbless.BJS2_25366_Task_2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private DesignResources designResources;
    private MarketingResources marketingResources;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            designResources.addFile("Design_Draft_%d".formatted(i + 1));
            marketingResources.addFile("Marketing_Suggestions_%d".formatted(i + 1));
            designResources.readFiles();
        }
    }
}
