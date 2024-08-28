package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {
    public Future<Robot> fight(Robot robot, Robot robot2){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        val future = executorService.submit(()->{
            try {
                log.info("starting fight");
                Thread.sleep(1000);
                return robot;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.MINUTES)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return future;
    }
}
