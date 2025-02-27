package school.faang.task_63401;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int DURATION_SECONDS = 2;

    public static void main(String[] args) {
        House starkHouse = new House(List.of("Лорд", "Рыцарь", "Маг"));

        User jon = new User("Джон", starkHouse);
        Thread t1 = createUserThread(jon);
        t1.start();

        User arya = new User("Арья", starkHouse);
        Thread t2 = createUserThread(arya);
        t2.start();

        User bran = new User("Бран", starkHouse);
        Thread t3 = createUserThread(bran);
        t3.start();

        User sansa = new User("Санса", starkHouse);
        Thread t4 = createUserThread(sansa);
        t4.start();

        waitForThreads(t1, t2, t3, t4);

        log.info("Все потоки завершены.");
    }

    private static Thread createUserThread(User user) {
        return new Thread(() -> {
            try {
                user.joinHouse();
                TimeUnit.SECONDS.sleep(DURATION_SECONDS);
            } catch (InterruptedException e) {
                log.error("Ошибка в потоке {}: {}", user.getName(), e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                user.leaveHouse();
            }
        });
    }

    private static void waitForThreads(Thread... threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка ожидания завершения потоков: {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
