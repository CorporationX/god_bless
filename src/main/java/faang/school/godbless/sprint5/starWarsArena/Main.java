package faang.school.godbless.sprint5.starWarsArena;

import faang.school.godbless.sprint5.starWarsArena.classes.Battle;
import faang.school.godbless.sprint5.starWarsArena.classes.Robot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        List<Future<Robot>> willWin = new ArrayList<>();
        Battle battle = new Battle();

        Robot redRobot = new Robot("Red", 10, 5);
        Robot blueRobot = new Robot("Blue", 11, 3);

        Robot greenRobot = new Robot("Green", 2, 15);
        Robot yellowRobot = new Robot("Yellow", 15, 3);

        willWin.add(battle.fight(redRobot, blueRobot));
        willWin.add(battle.fight(greenRobot, yellowRobot));

        for (Future<Robot> future : willWin) {
            try {
                System.out.println("Winner is " + future.get().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        battle.endBattle();
    }
}
