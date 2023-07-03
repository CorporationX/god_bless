package faang.school.godbless.Sprint4.StarWarsArena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

// Создание роботов
        Robot r2d2 = new Robot("R2-D2", 7, 5);
        Robot c3po = new Robot("C-3PO", 8, 4);

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
