package faang.school.godbless.module.fourth.async.wars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Battle {
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
            log.info("Победитель битвы: {}", winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    public Future<Robot> fight(Robot first, Robot second) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Robot> future = executorService.submit(() -> {
            log.info("Битва началась");
            Thread.sleep(2000);
            if (first.getAttackPower() > second.getDefensePower()) {
                return first;
            }
            return second;
        });
        executorService.shutdown();
        return future;
    }
}
