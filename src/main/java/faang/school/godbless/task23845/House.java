package faang.school.godbless.task23845;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private static List<Room> roomList = new ArrayList<>();
    private static List<Food> foodList = new ArrayList<>();

    public void collectFood(Room room1, Room room2){
        roomList.add(room1);
        roomList.add(room2);
        foodList.addAll(room1.getFood());
        foodList.addAll(room2.getFood());
    }

    public static void main(String[] args) {
        House house = new House();
        List<Food> snaks = new ArrayList<>();
        snaks.add(new Food("Тарталетки"));
        snaks.add(new Food("Чипсы"));
        List<Food> mainCours = new ArrayList<>();
        mainCours.add(new Food("Пицца"));
        mainCours.add(new Food("Паста"));
        Room livingRoom = new Room(snaks);
        Room diningRoom = new Room(mainCours);


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.schedule(() -> house.collectFood(livingRoom, diningRoom), 30, TimeUnit.SECONDS);
        }

        executorService.shutdown();
    }
}
