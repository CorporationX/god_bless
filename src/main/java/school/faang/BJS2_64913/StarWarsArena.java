package school.faang.BJS2_64913;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        // Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 2);
        Robot c3po = new Robot("C-3PO", 4, 3);

        // Запуск битвы
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        // Обработка результата битвы
        try {
            Robot winner = winnerFuture.get();
            log.debug("Победитель битвы: {} ", winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Ошибка при выполнении битвы: ", e);
        }
    }
}