package faang.school.godbless.starWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Robot> winner = executor.submit(() -> battle(robot1, robot2));
        executor.shutdown();
        return winner;
    }

    private Robot battle(Robot robot1, Robot robot2){
        while(robot1.getHealth() > 0 && robot2.getHealth()>0) {
            punch(robot1, robot2);
            punch(robot2, robot1);
        }
        return robot1.getHealth() > 0 ? robot1 : robot2;
    }

    private void punch(Robot defender, Robot attacker){
        int damage = attacker.getAttackPower() > defender.getDefensePower()?
                attacker.getAttackPower() - defender.getDefensePower() : 0;
        System.out.println(attacker.getName() + " наносит " + damage + " урона " + defender.getName());
        defender.setHealth(defender.getHealth() - damage);
        if(defender.getHealth() < 0){
            defender.setHealth(0);
        }
        System.out.println("У " + defender.getName() + " осталось " + defender.getHealth() + " жизней");
    }
}
