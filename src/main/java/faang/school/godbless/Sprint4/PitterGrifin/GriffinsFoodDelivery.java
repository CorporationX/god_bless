package faang.school.godbless.Sprint4.PitterGrifin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};
        for (String name : characterNames) {
            executors.execute(new FoodDeliveryTask(name, (int) (Math.random() * 50)));
        }
        executors.shutdown();
    }
}
