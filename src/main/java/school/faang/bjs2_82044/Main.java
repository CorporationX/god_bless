package school.faang.bjs2_82044;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = new House(new ArrayList<>(List.of("Лорд", "Рыцарь")));

        User nicholas = new User("Nicholas");
        User elizabeth = new User("Elizabeth");
        User kevin = new User("Kevin");

        Thread t1 = new Thread(() -> {
            try {
                nicholas.joinHouse(house);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.error("ошибка в потоке {}", nicholas);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                nicholas.leaveHouse(house);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                elizabeth.joinHouse(house);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.error("ошибка в потоке {}", elizabeth);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                elizabeth.leaveHouse(house);
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                kevin.joinHouse(house);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.error("ошибка в потоке {}", kevin);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                kevin.leaveHouse(house);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            log.error("Ошибка ожидания завершения потоков {}", e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("все потоки завершены");
    }
}