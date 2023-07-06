package star_wars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

// Создание роботов
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot ig88 = new Robot("IG-88", 15, 20);
        Robot ev9d9 = new Robot("EV-9D9", 10, 5);

// Запуск битвы
        Future<Robot> winnerFirstFightFuture = battle.fight(r2d2, c3po);
        Future<Robot> winnerSecondFightFuture = battle.fight(ig88,ev9d9);


// Обработка результата
        try {
            Robot winnerFirstFight = winnerFirstFightFuture.get();
            System.out.println("Победитель 1 битвы: " + winnerFirstFight.getName());
            Robot winnerSecondFight = winnerSecondFightFuture.get();
            System.out.println("Победитель 2 битвы: " + winnerSecondFight.getName());
            Future<Robot> winnerWinnersFightFuture = battle.fight(winnerFirstFight,winnerSecondFight);
            Robot winnerWinnersFight = winnerWinnersFightFuture.get();
            System.out.println("Победитель финальной битвы: " + winnerWinnersFight.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.finishBattle();
    }
}
