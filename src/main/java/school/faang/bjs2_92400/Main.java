package school.faang.bjs2_92400;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        House houseStark = new House("Дом Старков", new ArrayList<>(List.of("Король", "Рыцарь", "Ясновидец")));
        List<User> users = List.of(
                new User("Александр", "Рыцарь"),
                new User("Павел", "Король"),
                new User("Кирилл", "Ясновидец"),
                new User("Антон", "Король"),
                new User("Виталий", "Ясновидец")
        );
        Thread[] threads = new Thread[NUM_THREADS];

        log.info("Дом создан");
        for (int i = 0; i < threads.length; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                users.get(finalI).joinHouse(houseStark);
                Random timeInHouse = new Random();
                try {
                    Thread.sleep(timeInHouse.nextInt(7000));
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                users.get(finalI).leaveHouse(houseStark);
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
    }
}
