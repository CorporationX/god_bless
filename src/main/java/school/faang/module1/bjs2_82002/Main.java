package school.faang.module1.bjs2_82002;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.module1.bjs2_82002.Role.*;

@Slf4j
public class Main {

    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        List<Role> roles = new ArrayList<>(List.of(LORD, MAGE, KNIGHT));
        House house = new House(roles);
        List<User> users = List.of(
                new User("Jon"),
                new User("Daenerys"),
                new User("Bran"),
                new User("Arya"),
                new User("Sansa"),
                new User("Tyrion")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(users.size());

        for (User user : users) {
            executorService.execute(new UserRunner(user, house));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Не все задачи завершились за 10 секунд. Принудительное завершение");
                executorService.shutdownNow();
            } else {
                log.info("Все задачи завершены вовремя");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток ожидания завершения был прерван", e);
        }
    }
}