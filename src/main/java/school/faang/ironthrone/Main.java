package school.faang.ironthrone;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) {
        List<String> roles = new ArrayList<>(Arrays.asList("Lord", "Knight", "Meister"));
        House house1 = new House(roles);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String userName = "Player " + (i + 1);
            Thread thread = new Thread(() -> {
                User user = new User(userName);
                try {
                    user.joinHouse(house1);
                    Thread.sleep(SLEEP_TIME);
                    user.leaveHouse();
                } catch (InterruptedException e) {
                    log.error("{} был прерван: {}", userName, e.getMessage());
                    Thread.currentThread().interrupt();
                }
            });
            threads.add(thread);
        }

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка ожидания завершения потоков: {}", e.getMessage());
                Thread.currentThread().interrupt();
                threads.forEach(Thread::interrupt);
            }
        }
        log.info("\nВсе роли освобождены и все потоки завершены.");
    }
}
