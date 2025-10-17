package school.faang.bjs2_93333;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class MarketingDepartment implements Runnable {
    private static final int SLEEPING_TIME = 2;
    private final MarketingResources marketingResources;
    private final DesignResources designResources;

    @Override
    public void run() {
        //Если раскомментировать следующую строчку, то будет дедлок (это - первая половина задачи).
        //synchronized (designResources) {
        try {
            TimeUnit.SECONDS.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (marketingResources) {
            marketingResources.addFile("Новый дизайн");
        }
        designResources.readAllFiles();
        //}
    }
}
