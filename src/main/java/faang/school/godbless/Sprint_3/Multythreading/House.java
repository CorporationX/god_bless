package faang.school.godbless.Sprint_3.Multythreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFoods = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        for (Room room : rooms) {
            List<Food> temp = room.getFoodInRoom();
            if (temp.isEmpty()) continue;
            temp.stream()
                    .forEach(food -> {
                        System.out.printf("%d of %s was collected from the %s\n", food.getAmount(), food.getName(), room.getName());
                    });
            room.removeFood();
            collectedFoods.addAll(temp);
        }
        System.out.println(collectedFoods.toString());
    }

    public static void main(String[] args) {
        List<Food> foods1 = List.of(new Food("Cheese", 2), new Food("Apple", 5));
        List<Food> foods2 = List.of(new Food("Meat", 3), new Food("Bread", 1));
        List<Food> foods3 = List.of(new Food("Milk", 2), new Food("Mushroom", 4));

        House house = new House(List.of(new Room("Living room", foods1), new Room("Bedroom", foods2), new Room("Kitchen", foods3)));

        final int CORE_POOL_SIZE = 5;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        for (int i = 0; i < CORE_POOL_SIZE; ++i) {
            executor.schedule(house::collectFood, i * 30000, TimeUnit.MILLISECONDS);
        }

        executor.shutdown();
    }
}
