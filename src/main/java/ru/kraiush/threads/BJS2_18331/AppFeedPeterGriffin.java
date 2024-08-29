package ru.kraiush.threads.BJS2_18331;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

public class AppFeedPeterGriffin {

    public static void main(String[] args) {

        String[] characterNames = {"Peter", "Sharon", "Maggie", "Lewis", "Steve"};

        FoodDeliveryTask delivery = null;

        for (int i = 0; i < characterNames.length; i++) {
            delivery= new FoodDeliveryTask(characterNames[i]);
        }
        System.out.println("delivery:" + delivery);
        getFoodType();

        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);

        startTasksT(scheduledExecutor);
    }

    static void startTasksT(ScheduledExecutorService scheduledExecutor) {
        // Callable implemented as lambda
        Callable<String> t = ()->{
            System.out.println("Time of execution- " + new Date());
            return "Callable lambda is called";
        };
        System.out.println("Time before execution- " + new Date());
        // scheduling tasks with callable as param
        // it will execute after a delay of 5 Secs
        ScheduledFuture<String> sf = scheduledExecutor.schedule(t, 5, TimeUnit.SECONDS);
        try {
            System.out.println("Value- " + sf.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        scheduledExecutor.shutdown();
    }

    public static String getFoodType() {
        String[] foodTypes = {"pizza", "apple", "pioneapple", "fish", "beer", "banan"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
