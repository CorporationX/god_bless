package faang.school.godbless.sprint3.Mice_are_very_nice;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@RequiredArgsConstructor
public class House implements Runnable {
    private List<Room> rooms = List.of();
    private List<Food> foods = List.of();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Food> getCollectedFood() {
        return foods;
    }

    public synchronized void collectFood() {
        for (Room room : rooms) {
            List<Food> foodInRoom = room.getFood();
            foods.addAll(foodInRoom);
            foodInRoom.clear();
        }

    }

    @Override
    public void run() {
        collectFood();
    }

    public static void main(String[] args) {
        Food food = new Food("bread");
        Food food1 = new Food("milk");
        Food food2 = new Food("cheese");
        Food food3 = new Food("fish");

        Room room = new Room("bathrooms", List.of(food, food1));
        Room room1 = new Room("kitchen", List.of(food2, food3));

        House house = new House(List.of(room, room1));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Interrupted in main");
        }

        System.out.println("Food collected: " + house.getCollectedFood());
    }

}
