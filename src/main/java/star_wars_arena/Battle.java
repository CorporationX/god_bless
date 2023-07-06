package star_wars_arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    private ExecutorService executor;

    public Battle(){
        executor = Executors.newCachedThreadPool();
    }
    public Future<Robot> fight(Robot robot1, Robot robot2){
        return executor.submit(()->{
            int attackPowerRobot1 = robot1.getAttackPower();
            int attackPowerRobot2 = robot2.getAttackPower();
            int powerRobot1 = robot1.getDefensePower() - robot2.getAttackPower();
            int powerRobot2 = robot2.getDefensePower() - robot1.getAttackPower();
            if (powerRobot1>powerRobot2){
                return robot1;
            } else if (powerRobot2>powerRobot1) {
                return robot2;
            }else {
                if (attackPowerRobot1>attackPowerRobot2){
                    return robot1;
                }else {
                    return robot2;
                }
            }
        });
    }

    public void finishBattle(){
        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
