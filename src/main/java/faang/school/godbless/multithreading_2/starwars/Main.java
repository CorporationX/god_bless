package faang.school.godbless.multithreading_2.starwars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {

        Battle battle = new Battle();

        // Создание роботов
        Robot r2d2 = new Robot("R2-D2", 20, 7, 5);
        Robot c3po = new Robot("C-3PO", 20, 8, 4);

        // Запуск битвы
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        // Обработка результата
        try {
            Robot winner = winnerFuture.get(3, TimeUnit.SECONDS);
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException | TimeoutException e){
            e.printStackTrace();
        }
    }
}
