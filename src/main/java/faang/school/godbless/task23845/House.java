package faang.school.godbless.task23845;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static List<Room> roomList = new ArrayList<>();
    private static List<Food> foodList = new ArrayList<>();

    public void collectFood(Room room){
        foodList.addAll(room.getFood());
        roomList.remove(room);
        System.out.println("Еда собрана из " + room);
    }

    public static void main(String[] args) {
        House house = new House();
        List<Food> snaks = new ArrayList<>();
        snaks.add(new Food("Тарталетки"));
        snaks.add(new Food("Чипсы"));

        List<Food> hotDishes = new ArrayList<>();
        hotDishes.add(new Food("Пицца"));
        hotDishes.add(new Food("Паста"));

        roomList.add(new Room(snaks));
        roomList.add(new Room(hotDishes));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (Room room : roomList) {
            executorService.schedule(() -> house.collectFood(room), 30, TimeUnit.SECONDS);
        }
        executorService.shutdown();
    }
}
