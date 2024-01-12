package faang.school.godbless.multi_asyn.task6wars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        // Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot optimus = new Robot("Optimus Prime", 10, 10);
        Robot megatron = new Robot("Megatron", 9, 9);
        Robot bender = new Robot("Bender", 6, 5);

        // Запуск битвы
        Future<Robot> firstBattleWinner = battle.fight(r2d2, c3po);
        Future<Robot> secondBattleWinner = battle.fight(optimus, megatron);
        Future<Robot> thirdBattleWinner = battle.fight(bender, c3po);


// Обработка результата
        try {
            Robot winner1 = firstBattleWinner.get();
            System.out.println("Победитель первой битвы: " + winner1.getName());

            Robot winner2 = secondBattleWinner.get();
            System.out.println("Победитель второй битвы: " + winner2.getName());

            Robot winner3 = thirdBattleWinner.get();
            System.out.println("Победитель третьей битвы: " + winner3.getName());
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            System.out.println("Битва прервана");
        }

        battle.endBattle();
    }
}
