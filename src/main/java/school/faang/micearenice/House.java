package school.faang.micearenice;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@ToString
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();
    int roomCount = 2;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        if (rooms == null) {
            throw new IllegalArgumentException("There are no rooms in the house");
        }
        for (int i = 0; i < roomCount; i++) {
            if (rooms.isEmpty()) {
                break;
            }
            int randomRoomNr = getRandomRoomNr();
            Room room = rooms.get(randomRoomNr);
            List<Food> foods = room.getFoods();
            if (foods != null && !foods.isEmpty()) {
                collectedFood.addAll(foods);
            }
            room.removeFood();
        }
    }

    public boolean allFoodCollected(List<Room> rooms) {
        return rooms.stream().allMatch(r -> r.getFoods().isEmpty());
    }

    private int getRandomRoomNr() {
        Random random = new Random();
        return random.nextInt(rooms.size());
    }

    public static void main(String[] args) {
        List<Food> foods1 = new ArrayList<>();
        List<Food> foods2 = new ArrayList<>();
        List<Food> foods3 = new ArrayList<>();
        List<Food> foods4 = new ArrayList<>();
        foods1.add(new Food("Pizza"));
        foods1.add(new Food("Burger"));
        foods1.add(new Food("Sushi"));
        foods2.add(new Food("Pasta"));
        foods2.add(new Food("Salad"));
        foods3.add(new Food("Ice Cream"));
        foods3.add(new Food("Steak"));
        foods3.add(new Food("Tacos"));
        foods4.add(new Food("Soup"));
        foods4.add(new Food("Sandwich"));
        foods4.add(new Food("Cheese"));
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(foods1));
        rooms.add(new Room(foods2));
        rooms.add(new Room(foods3));
        rooms.add(new Room(foods4));
        rooms.add(new Room(foods2));

        House house = new House(rooms);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        while (!house.allFoodCollected(house.rooms)) {
            System.out.println("Collecting food ...");
            executor.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        }
        if (house.allFoodCollected(house.rooms)) {
            System.out.println("All food has been collected");
            executor.shutdown();
            System.out.println("Collected food list: " + house.collectedFood);
        }
    }
}
