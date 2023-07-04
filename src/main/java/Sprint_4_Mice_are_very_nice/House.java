package Sprint_4_Mice_are_very_nice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    List<Room> rooms;
    List<Food> food;

    public House(List<Room> rooms, List<Food> food) {
        this.rooms = rooms;
        this.food = food;
    }

    public synchronized void collectFood(Room room) {

//        System.out.println(Thread.currentThread().getName() + " Начался сбор " + food);
//        food = rooms.stream()
//                .flatMap(room -> room.getFoodForRoom().stream())
//                .toList();
//        food.forEach(System.out::println);
//        System.out.println(Thread.currentThread().getName() + " Закончился сбор "+ food);
//        rooms.forEach(room -> room.setFoodForRoom(new ArrayList<>()));
//        System.out.println(Thread.currentThread().getName() + " Уничтожил еду " + food);

        for (int i = 0; i < rooms.size(); i++) {

            food.addAll(room.getFoodForRoom());
            System.out.println(Thread.currentThread().getName() + " Все фрукты получил "+ food);
            room.setFoodForRoom(new ArrayList<>());
            System.out.println(Thread.currentThread().getName() + " Фрукты собраны " + room.getFoodForRoom());
        }
    }

    public static void main(String[] args) {

        List<Food> collectedFood = new ArrayList<>();
        Room room1 = new Room("кухня",
                List.of(new Food("фрукты"), new Food("авокадо")));
        Room room2 = new Room("ванная",
                List.of(new Food("черри"), new Food("овощи"), new Food("нут")));
        House house = new House(List.of(room1, room2), collectedFood);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.schedule(() -> house.collectFood(room1), 3000, TimeUnit.MILLISECONDS);
            executorService.schedule(() -> house.collectFood(room2), 3000, TimeUnit.MILLISECONDS);
        }


        executorService.shutdown();
        //еееее
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("Еда в доме собрана! Но только множество раз одноврменно всеми потоками");

    }

}
