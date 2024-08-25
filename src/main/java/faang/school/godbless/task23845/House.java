package faang.school.godbless.task23845;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class House {
    private static List<Room> roomList = new ArrayList<>();
    private static List<Food> foodList = new ArrayList<>();

    public void collectFood(){
        foodList.addAll(roomList.stream().flatMap(room -> room.getFood().stream()).collect(Collectors.toList()));
        roomList.clear();
    }

    public static void main(String[] args) {
        House house = new House();
        List<Food> snaks = new ArrayList<>();
        snaks.add(new Food("Тарталетки"));
        snaks.add(new Food("Чипсы"));

        List<Food> mainCours = new ArrayList<>();
        mainCours.add(new Food("Пицца"));
        mainCours.add(new Food("Паста"));

        roomList.add(new Room(snaks));
        roomList.add(new Room(mainCours));

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
            executorService.schedule(() -> house.collectFood(), 30, TimeUnit.SECONDS);
        executorService.shutdown();
    }
}
