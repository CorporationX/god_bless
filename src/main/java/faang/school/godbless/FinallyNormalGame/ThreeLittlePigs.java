package faang.school.godbless.FinallyNormalGame;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<PigThread> pigThreads = List.of(new Pig1Thread(), new Pig2Thread(), new Pig3Thread());
        pigThreads.forEach(executorService::execute);
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End program");
    }
}
