package faang.school.godbless.StarWars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Battle battle = new Battle();
        Future<Robot> result = battle.fight(
                new Robot("Оптимус Прайм!", 15, 5, 76),
                new Robot("Не Оптимус Прайм!", 13, 7, 76));
        Robot winner = result.get();
        System.out.println("Победил  - " + winner);
        battle.getExecutorService().shutdown();
    }
}
