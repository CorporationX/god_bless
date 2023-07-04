package Sprint_4_Task12;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class House {
    List<Room> rooms;
    List<Food> foods;

    public void collectFood() {
        System.out.println(Thread.currentThread().getName() + " Начался сбор еды : " + rooms);
        rooms.stream()
                .flatMap(room -> room.getFood().stream())
                .toList();
        System.out.println(Thread.currentThread().getName() + " Закончился сбор еды : " + rooms);
        rooms.forEach(room -> room.setFood(new ArrayList<>()));
        System.out.println(Thread.currentThread().getName() + " Уничтожил еду " + rooms);
    }

    @SneakyThrows
    public static void main(String[] args) {
        Room room = new Room(List.of(new Food("Яблоко"), new Food("Картошка"), new Food("Банан")));
        Room room2 = new Room(List.of(new Food("Груша"), new Food("Лимон"), new Food("Персик")));
        House house = new House(List.of(room, room2), new ArrayList<>());

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.schedule(house::collectFood, 3, TimeUnit.SECONDS);
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Конец");
    }
}
