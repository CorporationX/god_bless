package faang.school.godbless.BJS2_23755;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class House {
    static List<String> allFood = new ArrayList<>();
    private final static int NUMS_THREADS = 5;
    List<Room> rooms = List.of(
            new Room(List.of(new Food("Apple"), new Food("Milk"))),
            new Room(List.of(new Food("Bread"), new Food("Cheese"), new Food("Juice"))),
            new Room(List.of(new Food("Tomato"), new Food("Meat"), new Food("Cola"))),
            new Room(List.of(new Food("Milk"), new Food("Beer"), new Food("Cola"))),
            new Room(List.of(new Food("Cheese"), new Food("Apple"), new Food("Juice"))),
            new Room(List.of(new Food("Burrito"), new Food("Hamburger"), new Food("Coffee"))),
            new Room(List.of(new Food("Tea"), new Food("Banana"))),
            new Room(List.of(new Food("Chocolate"), new Food("Cola"))),
            new Room(List.of(new Food("Watermelon"), new Food("Pancake"))),
            new Room(List.of(new Food("Chicken"), new Food("Melon"), new Food("Tea")))
    );

    public static void main(String[] args) {
        House house = new House();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < NUMS_THREADS; i++) {
            executor.schedule(house::collectFood, 1, TimeUnit.NANOSECONDS);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            executor.shutdown();
            if (executor.awaitTermination(300, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (!executor.isTerminated()) {

        }
        System.out.println(allFood);
    }

    public List<String> collectFood() {
        List<String> listNames;
        listNames = rooms.stream()
                .filter(room -> !room.getFoodList().isEmpty())
                .limit(2)
                .flatMap(room -> room.getFoodList().stream()
                        .map(Food::getName)
                )
                .collect(Collectors.toList());

        allFood.addAll(listNames);
        removeFood();
        return listNames;
    }

    public void removeFood() {
        rooms.stream()
                .filter(room -> !room.getFoodList().isEmpty())
                .limit(2)
                .forEach(room -> room.setFoodList(new ArrayList<>()));
    }
}
