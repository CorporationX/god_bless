package faang.school.godbless.miceandnice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Setter
@Getter
public class House {

    private List<Room> rooms;
    private List<Food> collectedFood = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.setRooms(List.of(new Room(house.getFood()), new Room(house.getFood())));
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Food collected");
    }

    public void collectFood() {
        rooms.forEach(room -> {
            collectedFood.addAll(room.getFood());
            room.getFood().clear();
        });
    }


    private List<Food> getFood() {
        List<Food> meal = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Food food1 = new Food("Food " + (Math.random() * 25));
            meal.add(food1);
        }
        return meal;
    }
}
