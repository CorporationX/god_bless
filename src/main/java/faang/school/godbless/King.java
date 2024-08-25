package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class King {
    public static void main(String[] args) {
        Knight knight = new Knight("Robert");
        knight.addTrial(new Trial(knight.getName(), "pryjki v vysotu"));
        knight.addTrial(new Trial(knight.getName(), "plavanie"));
        Knight knight2 = new Knight("Serseya");
        knight2.addTrial(new Trial(knight2.getName(), "konki"));
        knight2.addTrial(new Trial(knight2.getName(), "snoubord"));


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        knight2.setExecutorService(executorService);
        knight.setExecutorService(executorService);

        knight2.startTrials();
        knight.startTrials();

        executorService.shutdown();
        try {
            if(executorService.awaitTermination(1, TimeUnit.SECONDS)){
                log.info("finished" );
            }else {
                log.info("finished else");
            }
        } catch (InterruptedException e) {
            log.info("EXCEPTIUON " + e);
        }

    }
}
