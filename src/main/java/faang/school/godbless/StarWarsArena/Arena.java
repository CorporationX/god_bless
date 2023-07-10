package faang.school.godbless.StarWarsArena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Arena {

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
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
