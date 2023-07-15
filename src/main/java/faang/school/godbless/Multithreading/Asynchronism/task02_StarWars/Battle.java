package faang.school.godbless.Multithreading.Asynchronism.task02_StarWars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Robot> future = executorService.submit(()->fightRobots(robot1, robot2));
        executorService.shutdown();
        return future;
    }
    public Robot fightRobots(Robot robot1, Robot robot2){
        Robot winner = null;
        if(robot1.getDefensePower()-robot2.getAttackPower()>robot2.getDefensePower()-robot1.getAttackPower()){
            winner = robot1;
        }
        if(robot1.getDefensePower()-robot2.getAttackPower()<robot2.getDefensePower()-robot1.getAttackPower()){
            winner = robot2;
        }
        if(robot1.getDefensePower()-robot2.getAttackPower()==robot2.getDefensePower()-robot1.getAttackPower()){
            winner = null;
        }
        return winner;
    }
}
