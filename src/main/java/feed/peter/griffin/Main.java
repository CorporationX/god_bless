package feed.peter.griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (String character : characterNames) {
            int foodAmount = new Random().nextInt(1,11);
            executorService.submit(new Delivery(character, foodAmount));
        }
        executorService.shutdown();
    }
}
