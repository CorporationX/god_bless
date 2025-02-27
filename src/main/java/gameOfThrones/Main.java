package gameOfThrones;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House starkHouse = new House("Старк", Arrays.asList("Лорд", "Рыцарь", "Маг"));

        User jon = new User("Джон");
        User arya = new User("Арья");
        User sansa = new User("Санса");
        User robb = new User("Робб");

        List<User> users = Arrays.asList(jon, arya, sansa, robb);

        List<Thread> threads = new ArrayList<>();

        for (User user : users) {
            Thread thread = new Thread(() -> {
                try {
                    user.joinHouse(starkHouse);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("Ошибка в потоке: " + e.getMessage());
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                } finally {
                    user.leaveHouse();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка ожидания завершения потоков: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        log.info("Все игроки завершили игру.");
    }
}

