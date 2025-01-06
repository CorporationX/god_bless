package school.faang.task51404;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 2;
    private static final int TERMINATION_TIMEOUT = 5;

    public static void main(String[] args) {

        DesignResources designResources = new DesignResources();
        MarketingResources marketingResources = new MarketingResources();
        DesignDepartment department = new DesignDepartment(designResources,
                marketingResources);
        MarketingDepartment marketing = new MarketingDepartment(marketingResources,
                designResources);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        executor.execute(department);
        executor.execute(marketing);

        executor.shutdown();

        try {
            if (executor.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.MINUTES)) {
                log.info("Все задачи выполнены успешно .");
            } else {
                executor.shutdownNow();
                log.error(" Задачи не выполнены, потоки остановлены принудительно . ");
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

    }
}
