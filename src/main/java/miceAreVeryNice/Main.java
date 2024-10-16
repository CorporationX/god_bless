package miceAreVeryNice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_AMOUNT = 5;

    public static void main(String[] args) {
        House house = new House(List.of(
                new Room("Hall", List.of(
                        new Food("Cheese"), new Food("Cherry")
                )),
                new Room("Bedroom", List.of(
                        new Food("Sausage"), new Food("Bread")
                )),
                new Room("Bathroom", List.of(
                        new Food("Mice"), new Food("Banana"), new Food("Fish")
                )),
                new Room("Kitchen", List.of(
                        new Food("Egg"), new Food("Cucumber"), new Food("Rice"),
                        new Food("Apple"), new Food("Grapes")
                )),
                new Room("Larder", List.of(
                        new Food("Ham"), new Food("Pizza"), new Food("Avocado"),
                        new Food("Melon"), new Food("Pear")
                ))
        ));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < THREAD_AMOUNT; i++) {
            if (!house.isAllFoodCollected()) {
                executorService.scheduleAtFixedRate(() -> house.collectFood(), 0, 5, TimeUnit.SECONDS);
            }
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        if (house.isAllFoodCollected()) {
            executorService.shutdown();
            System.out.println("Вся еда собрана!");
        }

        try {
            if (!executorService.awaitTermination(2, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        System.out.println("Вывод комнат: ");
        house.getRooms().forEach(System.out::println);
        System.out.println("Вывод собранной еды: ");
        house.getCollectedFood().forEach(System.out::println);
    }
}
