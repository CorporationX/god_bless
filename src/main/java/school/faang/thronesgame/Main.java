package school.faang.thronesgame;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;
import static school.faang.thronesgame.UserRole.KNIGHT;
import static school.faang.thronesgame.UserRole.LORD;
import static school.faang.thronesgame.UserRole.MAGICIAN;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
@Slf4j
public class Main {

    private static final int USER_NUMBERS = 7;

    public static void main(String[] args) {
        var roles = new ArrayList<>(
                List.of(LORD, KNIGHT, KNIGHT, MAGICIAN, LORD, MAGICIAN, KNIGHT, LORD, MAGICIAN, MAGICIAN)
        );
        var house = new House(roles);
        var executor = Executors.newFixedThreadPool(USER_NUMBERS);
        for (var i = 0; i < USER_NUMBERS; i++) {
            var user = new User("User%d".formatted(i));
            executor.execute(() -> {
                user.joinHouse(house);
                try {
                    log.info("Пользователь {} проводит время в доме", user);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Main | Поток {} прерван", Thread.currentThread().getName(), e.getCause());
                }
                user.leaveHouse(house);
            });
        }
        executor.shutdown();
        var executorName = executor.getClass().getSimpleName();
        log.info("{} | Запрос на завершение работы", executorName);
        try {
            if (!executor.awaitTermination(1, SECONDS)) {
                log.info("{} | Принудительное завершение работы", executorName);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("Поток {} прерван; {} | Принудительное завершение работы",
                    Thread.currentThread().getName(), executorName);
        }
        log.info("{} | Завершение работы", executorName);
        log.info("Количество свободных слотов: {}", house.getFreeSlotsNumber());
    }
}
