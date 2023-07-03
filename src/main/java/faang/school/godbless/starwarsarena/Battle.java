import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    @SneakyThrows
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Robot> winner = executorService.submit(() -> {
            while (robot1.getDefensePower()>0 && robot2.getDefensePower()>0){
                System.out.println(robot2.getDefensePower());
                robot2.setDefensePower(robot2.getDefensePower() - robot1.getAttackPower());
                if(robot2.getDefensePower()<0){
                    return robot1;
                }
                robot1.setDefensePower(robot1.getDefensePower() - robot2.getAttackPower());
                if(robot1.getDefensePower()<0){
                    return robot2;
                }
            }
            return robot1.getDefensePower()>robot2.getDefensePower()?robot1:robot2;
        });
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        return winner;
    }
}
