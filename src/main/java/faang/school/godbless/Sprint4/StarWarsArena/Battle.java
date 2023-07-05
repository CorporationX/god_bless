package faang.school.godbless.Sprint4.StarWarsArena;

import java.util.concurrent.*;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println("fight is started");
        Future<Robot> rob1 = executor.submit(()->bit(robot1,robot2));
        Future<Robot> rob2 = executor.submit(()->bit(robot2,robot1));

        while (!rob1.isDone() && !rob2.isDone()) {

        }
        executor.shutdown();

        if (rob1.isDone()){
            rob2.cancel(true);
            return rob1;
        } else {
            rob1.cancel(true);
            return rob2;
        }
    }

    private Robot bit(Robot attacker, Robot defender) throws InterruptedException {
        while (defender.getHealth()>0){
            defender.setHealth(defender.getHealth()-attacker.getAttackPower()+defender.getDefensePower());
            System.out.println("HP"+defender.getName()+" is "+defender.getHealth());
            Thread.sleep((long) (Math.random()*1000));
        }
        return attacker;
    }

}
