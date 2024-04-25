package faang.school.godbless.star_wars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

// Создание роботов
        Robot r2d2 = new Robot("R2-D2", 15, 3);
        Robot c3po = new Robot("C-3PO", 8, 8);

        Robot robot3 = new Robot("robot3", 15, 7);
        Robot robot4 = new Robot("robot4", 8, 8);

        Robot robot5 = new Robot("robot5", 15, 15);
        Robot robot6 = new Robot("robot6", 8, 15);

// Запуск битвы
        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);
        Future<Robot> winnerFuture2 = battle.fight(robot3, robot4);
        Future<Robot> winnerFuture3 = battle.fight(robot5, robot6);

// Обработка результата
        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Robot winner2 = winnerFuture2.get();
            System.out.println("Победитель битвы: " + winner2.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        try {
            Robot winner3 = winnerFuture3.get();
            System.out.println("Победитель битвы: " + winner3.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
