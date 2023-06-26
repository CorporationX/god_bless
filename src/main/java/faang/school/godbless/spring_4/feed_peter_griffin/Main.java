package faang.school.godbless.spring_4.feed_peter_griffin;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String[] characterName = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (String s : characterName) {
            service.execute(new FoodDeliveryTask(s, new Random().nextInt(1, 51)));
        }
        service.shutdown();
    }
}
