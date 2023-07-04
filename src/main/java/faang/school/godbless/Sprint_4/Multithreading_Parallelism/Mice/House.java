package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Mice;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@RequiredArgsConstructor
public class House {
    private final List<Room> rooms;
    private List<Food> collectedFoods = new ArrayList<>();

    public synchronized void collectFood() {
        //for (Room room : rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            System.out.printf("We now in the %s\n", room.getName());
            List<Food> temp = room.getFoodInRoom();
            if (temp.isEmpty()) continue;
            temp.stream()
                    .forEach(food -> {
                        try {
                            System.out.println("Collecting...");
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            System.out.println("Sleep Error");
                        }
                        System.out.printf("%d of %s was collected from the %s\n", food.getAmount(), food.getName(), room.getName());
                    });
            System.out.printf("%s was collected\n", room.getName());
            try {
                System.out.println("Going to the next room");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("sleep");
            }
            rooms.get(i).removeFood();
            collectedFoods.addAll(temp);
        }

        System.out.println(collectedFoods.toString());
    }

    public static void main(String[] args) {
        List<Food> foods1 = List.of(new Food("Cheese", 2), new Food("Apple", 5));
        List<Food> foods2 = List.of(new Food("Meat", 3), new Food("Bread", 1));
        List<Food> foods3 = List.of(new Food("Milk", 2), new Food("Mushroom", 4));

        House house = new House(List.of(new Room("Living room", foods1), new Room("Bedroom", foods2), new Room("Kitchen", foods3)));

        final int CORE_POOL_SIZE = 3;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        for (int i = 0; i < CORE_POOL_SIZE; ++i) {
            executor.schedule(house::collectFood, i * 3000, TimeUnit.MILLISECONDS);
        }

        executor.shutdown();
    }
}
