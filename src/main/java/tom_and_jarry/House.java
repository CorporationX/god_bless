package tom_and_jarry;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@ToString
public class House {
    private static List<Room> rooms;
    private static List<Food> collect_food;
    public House(List<Room> rooms) {
        House.rooms = rooms;
        House.collect_food = new ArrayList<>();
    }
    public static void collectFood(){
        rooms.stream()
                .map (Room :: getFood_in_room)
                .forEach(collect_food :: addAll);
                rooms.forEach(room -> room.getFood_in_room().clear());
    }

    @SneakyThrows
    public static void main(String[] args) {
        Room room1 = new Room(List.of(new Food("Хлеб"), new Food("Сыр")));
        Room room2 = new Room(List.of(new Food("Яблоко"), new Food("Банан")));
        List<Room> rooms = List.of(room1, room2);
        House house = new House(rooms);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            executorService.schedule(House::collectFood, i * 30, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("еда собрана");
    }
}
