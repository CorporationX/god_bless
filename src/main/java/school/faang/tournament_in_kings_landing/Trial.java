package school.faang.tournament_in_kings_landing;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Trial implements Runnable {
    @Setter
    private String knightName;
    private final String trialName;
    private static final int SLEEP_TIME = 2000;

    public Trial(String name){
        this.trialName = name;
    }

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