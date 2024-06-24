package multithreading.tournament;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Knight " + knightName + " is starting " + trialName + " trial");
    }

    public void startTrials() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit();
    }



}
