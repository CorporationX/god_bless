package tom_and_jerry;

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
    private List<Room> rooms;
    private List<Food> collectedFood;
    public static final int THREADS = 5;
    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.collectedFood = new ArrayList<>();
    }
    public void collectFood(){
        rooms.stream()
                .map (Room :: getFoodInRoom)
                .forEach(collectedFood :: addAll);
                rooms.forEach(room -> room.getFoodInRoom().clear());
    }

    @SneakyThrows
    public static void main(String[] args) {
        Room room1 = new Room(List.of(new Food("Хлеб"), new Food("Сыр")));
        Room room2 = new Room(List.of(new Food("Яблоко"), new Food("Банан")));
        List<Room> rooms = List.of(room1, room2);
        House house = new House(rooms);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(THREADS);
        for (int i = 0; i < 2; i++) {
            executorService.schedule(house::collectFood, i * 30, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("еда собрана");
    }
}
