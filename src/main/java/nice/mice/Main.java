package nice.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {

        Food milk = new Food("milk");
        Food bread = new Food("bread");
        Food onion = new Food("onion");
        Food cheese = new Food("cheese");
        Food parrot = new Food("parrot");

        Room room1 = new Room(new ArrayList<>(List.of(onion, bread)));
        Room room2 = new Room(new ArrayList<>(List.of(onion, milk, cheese)));
        Room room3 = new Room(new ArrayList<>(List.of(parrot, milk)));
        Room room4 = new Room(new ArrayList<>(List.of(bread, parrot, cheese)));
        Room room5 = new Room(new ArrayList<>(List.of(cheese, milk, onion)));

        House house = new House(new ArrayList<>(List.of(room1, room2, room3, room4, room5)), new ArrayList<>());
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Tom and Jerry collect food");
            house.collectFood();
            if (house.allFoodCollected()) {
                executorService.shutdown();
                System.out.println("Tom and Jerry collected all the food");
            }
        }, 0, 30, TimeUnit.SECONDS);
    }
}
