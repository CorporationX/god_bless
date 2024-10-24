package school.faang.Multithreading.sprint_4.StarWars;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    ExecutorService executor = Executors.newFixedThreadPool(10);

    public Future<Robot> fight(Robot robot1, Robot robot2){
        Future<Robot> robotFuture = executor.submit(() -> {
            if(robot1.getAttackPower() + robot1.getDefensePower() > robot2.getAttackPower() + robot2.getDefensePower()){
               return robot1;
            } else if(robot1.getAttackPower() + robot1.getDefensePower() == robot2.getAttackPower() + robot2.getDefensePower()) {
                Random random = new Random();
                List<Robot> robots = Arrays.asList(robot1, robot2);
                int randRob = random.nextInt(robots.size());
                return robots.get(randRob);
            }else {
               return robot2;
            }
        });

        return robotFuture;
    }

    public void shutdown(){
        executor.shutdown();
    }
}
