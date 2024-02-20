package feed.peter.griffin;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]) {
        Random random = new Random();
        int minDelay = 1000;
        int maxDelay = 5000;
        int randomDelay = random.nextInt((maxDelay - minDelay) + 1) + minDelay;

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};



    }
}
