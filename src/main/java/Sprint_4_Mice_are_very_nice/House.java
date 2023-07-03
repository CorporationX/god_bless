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

    public void collectFood(House house, Room room) {

        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < room.getFoodForRoom().size(); i++) {
                food.add((Food) room.getFoodForRoom(j));

            }
        }

    }
//    public static void main(String[] args) {
//
    //List<Food> collectedFood = new ArrayList<>();
//        Room room1 = new Room("кухня",
//                List.of(new Food("фрукты"), new Food("авокадо")));
//        Room room2 = new Room("ванная",
//                List.of(new Food("черри"), new Food("овощи"), new Food("нут")));
//        House house = new House(List.of(room1, room2), collectedFood);
//
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//
//        for (int i = 0; i < 5; i++) {
//            executorService.schedule(() -> house.collectFood(), 3000, TimeUnit.MILLISECONDS);
//        }
//        executorService.shutdown();
//
//    }


}
