package arena;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

// Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

// Запуск битвы
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

// Обработка результата
        try {
            Robot winner = winnerFuture.get();
            if (winner != null) {
                log.info("Winner is: " + winner.getName());
            } else {
                log.info("Tie!");
            }
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
        battle.endBattle();
    }
}
