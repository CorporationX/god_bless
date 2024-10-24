package school.faang.BJS2_36163;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final Random random = new Random();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("Недостаточно комнат для сбора еды.");
            return;
        }

        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        List<Food> foodFromRoom1 = new ArrayList<>(room1.getFoods());
        for (Food food : foodFromRoom1) {
            collectedFood.add(food);
            room1.removeFood(food);
        }

        List<Food> foodFromRoom2 = new ArrayList<>(room2.getFoods());
        for (Food food : foodFromRoom2) {
            collectedFood.add(food);
            room2.removeFood(food);
        }

        System.out.println("Еда собрана из двух комнат.");
    }
    public static void main(String[] args) {
        House house = new House();

        Room kitchen = new Room();
        kitchen.addFood(new Food("Яблоко"));
        kitchen.addFood(new Food("Банан"));

        Room livingRoom = new Room();
        livingRoom.addFood(new Food("Печенье"));
        livingRoom.addFood(new Food("Чипсы"));

        house.addRoom(kitchen);
        house.addRoom(livingRoom);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
        }

        executorService.schedule(() -> {
            executorService.shutdown();
            System.out.println("Еда в доме собрана!");
        }, 1, TimeUnit.MINUTES);
    }
}
