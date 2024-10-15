package school.faang.mice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private static final int THREAD_POOL_SIZE = 5;
    private static final long DELAY = 0;
    private static final long PERIOD = 30;
    private static final int ALL_FOOD_SIZE = 15;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final String name;

    public static void main(String[] args) {
        House tomHouse = new House("tomHouse");
        tomHouse.initializeHouse();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);
        executor.scheduleAtFixedRate(() -> tomHouse.collectFood(executor, tomHouse), DELAY, PERIOD, TimeUnit.SECONDS);
    }

    private void collectFood(ScheduledExecutorService executor, House house) {
        List<Room> rooms = house.getRooms();
        List<Food> collectedFood = house.getCollectedFood();
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));
        if (room1.hasFood()) {
            collectedFood.addAll(room1.removeAllFood());
        }

        if (room2.hasFood()) {
            collectedFood.addAll(room2.removeAllFood());
        }
        allFoodCollected(executor, house);
    }

    private void allFoodCollected(ScheduledExecutorService executor, House house) {
        if (house.collectedFood.size() == ALL_FOOD_SIZE) {
            executor.shutdown();
            System.out.printf("Еда в доме %s собрана!", house.getName());
        }
    }

    private void initializeHouse() {
        Food cheese = new Food("cheese");
        Food milk = new Food("milk");
        Food pie = new Food("pie");
        Food sandwich = new Food("sandwich");
        Food apple = new Food("apple");
        Food meat = new Food("meat");
        Room room1 = new Room(new ArrayList<>() {{
            add(cheese);
            add(milk);
            add(pie);
            add(meat);
        }});
        Room room2 = new Room(new ArrayList<>() {{
            add(sandwich);
            add(apple);
            add(meat);
        }});
        Room room3 = new Room(new ArrayList<>() {{
            add(cheese);
            add(milk);
            add(pie);
            add(sandwich);
            add(apple);
            add(meat);
        }});
        Room room4 = new Room(new ArrayList<>() {{
            add(cheese);
            add(meat);
        }});
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
    }
}
