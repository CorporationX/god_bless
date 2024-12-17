package school.faang.task48825;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.task48825.Role.*;

@Slf4j
public class Main {
    private static final int THREAD_POOL = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);

        House house = new House("Ланистеры",
                new HashSet<>(Set.of(MAGE, KNIGHT, LORD)));

        List<User> users = new ArrayList<>(List.of(
                new User("Джон Сноу", KNIGHT, house),
                new User("Джейми Ланистер", KNIGHT, house),
                new User("Тирион Ланистер", LORD, house),
                new User("Мелисандра", MAGE, house)
        ));

        users.forEach(user -> {
            executorService.execute(user::joinHouse);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        });

        executorService.execute(() -> users.get(0).leaveHouse());

        executorService.shutdown();
    }
}
