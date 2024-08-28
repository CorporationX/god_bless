package faang.school.godbless.BJS2_23878;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class House {
    private static final List<Room> rooms = new ArrayList<>();
    private static List<Food> foods = new ArrayList<>();

    public static void main(String[] args) {

        Room bedRoom = new Room("Спальня");
        bedRoom.addFood(new Food("сыр", 5));
        bedRoom.addFood(new Food("хлеб", 2));
        bedRoom.addFood(new Food("колбаса", 8));

        Room livingRoom = new Room("Гостинная");
        livingRoom.addFood(new Food("сыр", 8));
        livingRoom.addFood(new Food("масло", 3));
        livingRoom.addFood(new Food("паштет", 1));

        Room kitchenRoom = new Room("Кухня");
        kitchenRoom.addFood(new Food("яйцо", 10));
        kitchenRoom.addFood(new Food("лаваш", 2));
        kitchenRoom.addFood(new Food("семечки", 120));

        Room bathRoom = new Room("Ванная");
        kitchenRoom.addFood(new Food("картофель", 3));
        kitchenRoom.addFood(new Food("макароны", 1));
        kitchenRoom.addFood(new Food("рис", 5));

        rooms.add(bedRoom);
        rooms.add(livingRoom);
        rooms.add(kitchenRoom);
        rooms.add(bathRoom);

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.schedule(House::collectFood, 5, TimeUnit.SECONDS);
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(foods);
        foods.clear();

        service.shutdown();
        System.out.println("Еда в доме собрана!");
    }

    static private void collectFood() {
        foods = rooms.stream().flatMap(room -> room.getFoods().stream()).collect(Collectors.toList());
    }
}
