package faang.school.godbless.eat_Piter_Griffin;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GriffinsFoodDelivery {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] characterNames = {"Peter", "Lois", "Meg", "Chris", "Stewie"};

        //для каждого  героя создаём своё кол-во еды
        var foodDeliveryTasks = Arrays.stream(characterNames)
                .map(task -> new FoodDeliveryTask(task,
                        FoodDeliveryTask.RANDOM_FOOD_TYPE
                                .nextInt(50)))
                .toList();

        //кормим героев
        foodDeliveryTasks.forEach(executor::submit);
        executor.shutdown();
    }
}
