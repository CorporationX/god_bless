package faang.school.godbless.module1.sprint3.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private String knightName;
    private String trialName;


    public static void startTrials(List<Trial> trialList) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        trialList.forEach(service::execute);
        try {
            boolean result = service.awaitTermination(new Random().nextLong(1, 5), TimeUnit.SECONDS);
            log.info("Trial result: {}", result);
        } catch (InterruptedException e) {
            log.error("Service interrupted", e);
        }
        service.shutdown();
    }

    @Override
    public void run() {
        System.out.println(knightName + " execute " + trialName);
    }
}
