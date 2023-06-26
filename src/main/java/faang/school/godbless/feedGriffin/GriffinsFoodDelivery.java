package faang.school.godbless.feedGriffin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        for (int i = 0; i < 3; i++) {
            service.submit(new FoodDeliveryTask(characterNames[i],
                    (int) Math.round(Math.random()*10)));
        }
        service.shutdown();
    }
}
