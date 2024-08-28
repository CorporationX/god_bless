package faang.school.godbless.BJS2_23859;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> food = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        initialize(house.getRooms());

        var scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            scheduledExecutorService.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }

        scheduledExecutorService.shutdown();
        if (scheduledExecutorService.awaitTermination(10, TimeUnit.MINUTES)) {
            System.out.printf("All food collected. Total food is %d\n", house.getFood().size());
            System.out.printf("Food in kitchen = %d; Food in living room = %d\n",
                    house.getRooms().get(0).getFood().size(),
                    house.getRooms().get(1).getFood().size());
        } else {
            System.out.println("Not all food collected");
        }
    }

    public void collectFood() {
        rooms.forEach(room -> {
            food.addAll(room.getFood());
            room.getFood().clear();
        });
    }

    private static void initialize(List<Room> rooms) {
        var liveRoom = new Room("Living Room");
        var kitchenRoom = new Room("Kitchen");

        liveRoom.getFood().addAll(
                List.of(
                        new Food("Cheese"),
                        new Food("Pineapple"),
                        new Food("Milk"),
                        new Food("Bread"),
                        new Food("Chicken"),
                        new Food("Pepper")
                )
        );
        kitchenRoom.getFood().addAll(
                List.of(
                        new Food("Pepperoni"),
                        new Food("Meat"),
                        new Food("Sour cream"),
                        new Food("Mushrooms"),
                        new Food("Watermelon")
                )
        );
        rooms.addAll(List.of(liveRoom, kitchenRoom));

    }
}