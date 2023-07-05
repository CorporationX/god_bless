package faang.school.godbless.Sprint5_1.tast2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    ExecutorService executor = Executors.newFixedThreadPool(3);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            Robot firstAttacker = Math.random() < 0.5 ? robot1 : robot2;
            Robot secondAttacker = (firstAttacker == robot1) ? robot2 : robot1;

            while(firstAttacker.getDefensePower()>0 && secondAttacker.getDefensePower()>0){
                secondAttacker.setDefensePower(secondAttacker.getDefensePower()-firstAttacker.getAttackPower());
                if (secondAttacker.getDefensePower() <=0){
                    return firstAttacker;
                }
                firstAttacker.setDefensePower(firstAttacker.getDefensePower()-secondAttacker.getAttackPower());
                if (firstAttacker.getDefensePower() <=0){
                    return secondAttacker;
                }
            }
            return null;
        });
    }
}
