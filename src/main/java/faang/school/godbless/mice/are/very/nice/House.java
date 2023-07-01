package faang.school.godbless.mice.are.very.nice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Getter
@Setter
@ToString
public class House {
    private List<Food> collectedFoods = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public void collectFood() {
        int temp = 0;
        for (int i = 0; i < rooms.size(); i++) {
            List<Food> foods = rooms.get(i).getFoods();
            if (temp == 2) {
                break;
            }
            if (foods.isEmpty()) continue;

            collectedFoods.addAll(foods);
            temp++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        House house = new House();

        Room badRoom = new Room();
        badRoom.getFoods().add(new Food("Eggs"));
        badRoom.getFoods().add(new Food("Banana"));

        Room kitchen = new Room();
        kitchen.getFoods().add(new Food("Bread"));
        kitchen.getFoods().add(new Food("Spaghetti"));
        kitchen.getFoods().add(new Food("Oranges"));

        Room bigRoom = new Room();
        bigRoom.getFoods().add(new Food("Ice cream"));
        bigRoom.getFoods().add(new Food("Apples"));
        bigRoom.getFoods().add(new Food("Watermelon"));

        house.rooms.add(badRoom);
        house.rooms.add(kitchen);
        house.rooms.add(bigRoom);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }
        executor.shutdown();

        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("All food is collected");
        }

    }

}
