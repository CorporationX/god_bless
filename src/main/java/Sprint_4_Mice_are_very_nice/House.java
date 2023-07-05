package Sprint_4_Mice_are_very_nice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
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

        //for (int i = 0; i < rooms.size(); i++) {

        food.addAll(room.getFoodForRoom());
        System.out.println(Thread.currentThread().getName() + ": " + room.getRoomName() + " Все фрукты получил " + food);
        System.out.println(Thread.currentThread().getName());
        room.setFoodForRoom(new ArrayList<>());
        System.out.println(Thread.currentThread().getName() + ": " + room.getRoomName() + " Фрукты собраны " + room.getFoodForRoom());
        //}
    }

    public static void main(String[] args) {

        List<Food> collectedFood = new ArrayList<>();
        Room room1 = new Room("кухня-1", List.of(new Food("фрукты"), new Food("авокадо")));
        Room room2 = new Room("гостинная-2", List.of(new Food("черри"), new Food("овощи"), new Food("нут")));
        Room room3 = new Room("прихожая-3", List.of(new Food("черри"), new Food("овощи"), new Food("нут")));
        Room room4 = new Room("детская-4", List.of(new Food("черри"), new Food("овощи"), new Food("нут")));
        Room room5 = new Room("взрослая-5", List.of(new Food("черри"), new Food("овощи"), new Food("нут")));
        Room room6 = new Room("балкон-6", List.of(new Food("черри"), new Food("овощи"), new Food("нут")));
        House house = new House(List.of(room1, room2, room3, room4, room5, room6), collectedFood);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        //for (int i = 0; i < 3; i++) {
        executorService.schedule(() -> house.collectFood(room1), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room2), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room3), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room4), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room5), 3000, TimeUnit.MILLISECONDS);
        executorService.schedule(() -> house.collectFood(room6), 3000, TimeUnit.MILLISECONDS);
        //}

        executorService.shutdown();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(Thread.currentThread().getName());
        try {
            executorService.awaitTermination(100_000,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName());

        System.out.println("Еда в доме собрана!");
    }
}
