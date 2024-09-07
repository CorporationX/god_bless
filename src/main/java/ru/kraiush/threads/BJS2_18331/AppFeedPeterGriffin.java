package ru.kraiush.threads.BJS2_18331;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class AppFeedPeterGriffin {

    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Sharon", "Maggie", "Lewis", "Steve"};

        List<FoodDeliveryTask> listDelivery = new ArrayList<>();

        System.out.print(String.join("", Collections.nCopies(130, "-")));

        for (String characterName : characterNames) {
            listDelivery.add(new FoodDeliveryTask(characterName, new Food(getFoodType(), ThreadLocalRandom.current().nextInt(1, 10))));
        }
        System.out.println("\nlist delivery:" + listDelivery);

        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);

        startTasksT(scheduledExecutor, listDelivery);
        System.out.print(String.join("", Collections.nCopies(130, "-")));
    }

    static void startTasksT(ScheduledExecutorService pool, List<FoodDeliveryTask> listDelivery) {

        System.out.println("\nCurrent Time = " + new Date());
        for (FoodDeliveryTask worker : listDelivery) {
            pool.schedule(worker, 5, TimeUnit.SECONDS);
        }
        pool.shutdown();
        while (!pool.isTerminated()) {
            //wait for all tasks to finish
        }
        System.out.println("Current Time = " + new Date());
        System.out.println("\nList of characters: all their food were eaten:");
        System.out.println(listDelivery);
    }

    public static String getFoodType() {
        String[] foodTypes = {"pizza", "apple", "pioneapple", "fish", "beer", "banan"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

}
