package faang.school.godbless.BJS2_11785;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private List<Room> rooms;
    private final List<Food> foods = new ArrayList<>();
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        List<Food> kitchenFoods = List.of(new Food("Сосиска"),
                new Food("Колбаса"),
                new Food("Огурец"));
        List<Food> livingRoomFoods = List.of(new Food("Помидор"),
                new Food("Торт"),
                new Food("Яблоко"));
        List<Food> bedroomFoods = List.of(new Food("Морковь"),
                new Food("Печенье"),
                new Food("Котлета"));

        house.rooms = List.of(new Room("Гостиная", livingRoomFoods),
                new Room("Спальня", bedroomFoods),
                new Room("Кухня", kitchenFoods));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.schedule(() -> collectFood(house), 30 * i, TimeUnit.SECONDS);
        }
        executorService.shutdown();
        if (executorService.awaitTermination(3, TimeUnit.MINUTES)) {
            System.out.println("Еда в доме собрана!");
        }
    }

    private static void collectFood(House house) {
        Room firstRoom = getRandomRoom(house);
        Room secondRoom = getRandomRoom(house);
        takeAndRemoveFood(house, firstRoom, getRandomFood(firstRoom));
        takeAndRemoveFood(house, secondRoom, getRandomFood(secondRoom));
    }

    private static Food getRandomFood(Room room) {
        return room.getFoods().get(random.nextInt(0, room.getFoods().size()));
    }

    private static Room getRandomRoom(House house) {
        return house.rooms.get(random.nextInt(0, house.rooms.size()));
    }

    private static void takeAndRemoveFood(House house, Room room, Food food) {
        house.foods.add(food);
        room.getFoods().remove(food);
    }
}
