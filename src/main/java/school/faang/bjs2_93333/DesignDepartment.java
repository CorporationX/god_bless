package school.faang.bjs2_93333;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class DesignDepartment implements Runnable {
    private static final int SLEEPING_TIME = 2;
    private final DesignResources designResources;
    private final MarketingResources marketingResources;

    @Override
    public void run() {
        //Если раскомментировать следующую строчку, то будет дедлок (это - первая половина задачи).
        //synchronized (marketingResources) {
        try {
            TimeUnit.SECONDS.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (designResources) {
            designResources.addFile("Новый маркетинг");
        }
        marketingResources.readAllFiles();
        //}
    }
}
