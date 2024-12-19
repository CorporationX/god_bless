package school.faang.spring3.task_48517;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) {
        List<Food> foods1 = new ArrayList<>();
        foods1.add(new Food("apple1"));
        foods1.add(new Food("carrot1"));
        List<Food> foods2 = new ArrayList<>();
        foods2.add(new Food("apple2"));
        foods2.add(new Food("carrot2"));
        List<Food> foods3 = new ArrayList<>();
        foods3.add(new Food("apple3"));
        foods3.add(new Food("carrot3"));
        List<Food> foods4 = new ArrayList<>();
        foods4.add(new Food("apple4"));
        foods4.add(new Food("carrot4"));
        List<Food> foods5 = new ArrayList<>();
        foods5.add(new Food("apple5"));
        foods5.add(new Food("carrot5"));
        House house = new House();
        house.addRoom(new Room(foods1));
        house.addRoom(new Room(foods2));
        house.addRoom(new Room(foods3));
        house.addRoom(new Room(foods4));
        house.addRoom(new Room(foods5));


        ExecutorService service = Executors.newFixedThreadPool(POOL_SIZE);
        service.execute(() -> {

            house.collectFood();
            if (house.allFoodCollected()) {
                service.shutdown();
                System.out.println("All food collected");
            }

        });

    }
}
