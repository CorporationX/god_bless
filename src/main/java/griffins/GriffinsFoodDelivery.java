package griffins;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        Random rnd = new Random();
        String[] names = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new FoodDeliveryTask(names[rnd.nextInt(names.length)], rnd.nextInt(1, 50)));
        }
        executorService.close();
    }
}
