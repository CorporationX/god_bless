package TomAndJerry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static final List<Food> collectedFood = new ArrayList<>();
    private final List<Food> foodList = List.of(
            new Food("Apple"),
            new Food("Banana"),
            new Food("Tomato"),
            new Food("Orange Juice"),
            new Food("Potato"),
            new Food("Chicken"),
            new Food("Potato"),
            new Food("Cheese"),
            new Food("Fish"),
            new Food("Vodka"),
            new Food("Bread"),
            new Food("Nuts")
    );
    private final List<Room> roomList = List.of(
            new Room("Bedroom"),
            new Room("Kitchen"),
            new Room("BathRoom"),
            new Room("Hall")
    );

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.fillRoomsWithFood();

        for (Room room : house.roomList) {
            System.out.println(room.getFoodList());
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.schedule(house::coollectFood, 0, TimeUnit.SECONDS);
            Thread.sleep(3000);
        }
        executorService.shutdown();

        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
        }

        System.out.println(collectedFood);
        System.out.println("Еда собрана");

    }

    public void fillRoomsWithFood() {
        int roomIndex = 0;
        for (Room room : roomList) {
            for (Food food : foodList) {
                room.addFood(food);
            }
        }
    }

    public void coollectFood() {
        //Найти две комнаты где есть еда
        List<Room> foundedRooms = new ArrayList<>();
        int roomCount = 0;
        for (Room room : roomList) {
            if (roomCount == 2) {
                break;
            }
            if (!room.getFoodList().isEmpty()) {
                foundedRooms.add(room);
                roomCount++;
            }
        }
        //Собрать еду из каждой комнаты
        //Хотел с помощью stream сделать, но не сообразил как(
        for (Room foundedRoom : foundedRooms) {
            collectedFood.addAll(foundedRoom.getFoodList());
            foundedRoom.getFoodList().clear();
        }
    }
}

