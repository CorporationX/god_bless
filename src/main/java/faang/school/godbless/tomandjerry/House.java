package faang.school.godbless.tomandjerry;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        House house = new House();
        house.initialize();

        CountDownLatch latch = new CountDownLatch(house.getRooms().size());

        for (Room room : house.getRooms()) {
            executorService.schedule(() -> {
                try {
                    house.collectFood(room);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            }, 1, TimeUnit.SECONDS);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }

        System.out.println("Еда в доме собрана за + " + (System.currentTimeMillis() - start) + " ms");
    }

    private void collectFood(Room room) throws InterruptedException {
        collectedFood.addAll(room.getFood());
        room.setFood(new ArrayList<>());
    }

    private void initialize() {
        this.setRooms(List.of(
                new Room("Living Room", List.of(
                        new Food("Chips"),
                        new Food("Crackers"),
                        new Food("Yogurt"),
                        new Food("Chocolate Cake"))
                ),
                new Room("Bedroom", List.of(
                        new Food("Pretzels"),
                        new Food("Granola Bars"),
                        new Food("Yogurt"),
                        new Food("Apple Pie"))
                ),
                new Room("Kitchen", List.of(
                        new Food("Popcorn"),
                        new Food("Nuts"),
                        new Food("Cheese Sticks"),
                        new Food("Apple Pie"))
                ),
                new Room("Bathroom", List.of(
                        new Food("Pretzels"),
                        new Food("Granola Bars"),
                        new Food("Hummus with Veggies"))
                ),
                new Room("Dining Room", List.of(
                        new Food("Pretzels"),
                        new Food("Nuts"),
                        new Food("Cheese Sticks"),
                        new Food("Ice Cream Sundae"))
                ),
                new Room("Home Office", List.of(
                        new Food("Chips"),
                        new Food("Crackers"),
                        new Food("Fruit Snacks"),
                        new Food("Chocolate Cake"))
                ),
                new Room("Guest Room", List.of(
                        new Food("Popcorn"),
                        new Food("Granola Bars"),
                        new Food("Yogurt"),
                        new Food("Ice Cream Sundae"))
                ),
                new Room("Basement", List.of(
                        new Food("Pretzels"),
                        new Food("Nuts"),
                        new Food("Cheese Sticks"),
                        new Food("Chocolate Cake"))
                ),
                new Room("Attic", List.of(
                        new Food("Chips"),
                        new Food("Crackers"),
                        new Food("Fruit Snacks"),
                        new Food("Apple Pie"))
                ),
                new Room("Laundry Room", List.of(
                        new Food("Popcorn"),
                        new Food("Fruit Snacks"),
                        new Food("Hummus with Veggies"),
                        new Food("Ice Cream Sundae"))
                )
        ));
    }
}
