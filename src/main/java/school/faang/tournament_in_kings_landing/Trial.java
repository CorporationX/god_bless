package school.faang.tournament_in_kings_landing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;
    private static final int SLEEP_TIME = 2000;

    @Override
    public void run() {
        try {
            System.out.println(trialName + " performed by " + knightName + " has begun!");
            Thread.sleep(SLEEP_TIME);
            System.out.println(trialName + " performed by " + knightName + " has come to an end!");
        } catch (InterruptedException e) {
            System.out.println(trialName + " performed by " + knightName + " has benn interrupted!");
            log.error("Exception in threads connected to sleep() method has occurred", e);
            e.printStackTrace();
        }

    }
}
