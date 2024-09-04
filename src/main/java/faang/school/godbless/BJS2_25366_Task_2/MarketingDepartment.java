package faang.school.godbless.BJS2_25366_Task_2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MarketingDepartment implements Runnable {
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
            marketingResources.addFile("Marketing_Report_%d".formatted(i + 1));
            designResources.readFiles();
        }
    }
}
