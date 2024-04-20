package BJS2_5748;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@ToString
public class House {
    private final List<Room> ROOMS;
    private static final int NUM_THREADS = 2;
    private List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        for (Room room : ROOMS) {
            for (int i = room.getFoods().size(); i != 0; i--) {
                collectedFood.add(room.getFoods().get(i - 1));
                room.getFoods().remove(i - 1);
            }
            System.out.println(room.getName() + " была очищена от еды");
        }
    }

    public static void main(String[] args) {

        House house = initialize();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_THREADS; i++) {
            service.schedule(house::collectFood, 30, TimeUnit.SECONDS);
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(70, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }
        if (house.ROOMS.stream().allMatch(room -> room.getFoods().isEmpty())) {
            System.out.println("Еда была собрана");
        }
    }

    public static House initialize() {
        String[] products = {"яблоко", "банан", "груша", "сосиски", "колбаса", "сыр", "пицца", "торт"};
        List<Food> foodInFirstRoom = new ArrayList<>();
        List<Food> foodInSecondRoom = new ArrayList<>();


        for (int i = 0; i < 3; i++) {
            foodInFirstRoom.add(new Food(products[new Random().nextInt(products.length)]));
            foodInSecondRoom.add(new Food(products[new Random().nextInt(products.length)]));
        }

        Room bathRoom = new Room("Душевая", foodInFirstRoom);
        Room bedRoom = new Room("Спальня", foodInSecondRoom);


        return new House(List.of(bathRoom, bedRoom));
    }
}
