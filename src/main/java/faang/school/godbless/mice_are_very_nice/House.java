package faang.school.godbless.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Getter
@Setter
public class House {
    private List<Room> rooms;
    private List<Food> foods;


    public void collectFood() {
        for(int i = 0; i < rooms.size(); i++) {
            List<Food> foodInRoom = rooms.get(i).getFoodsInRoom();
            for(int j = 0; j < foodInRoom.size(); j++) {
                foods.add(foodInRoom.get(j));
                rooms.get(i).setFoodsInRoom(null);
            }
        }
    }
    @SneakyThrows
    public static void main(String[] args) {
        Room room1 = new Room(List.of(new Food("apple"), new Food("cheese")));
        Room room2 = new Room(List.of(new Food("shawarma"), new Food("sandwich")));

        List<Room> rooms = List.of(room1, room2);
        List<Food> foods = new ArrayList<>();
        House house = new House(rooms, foods);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for(int i = 0; i < house.getRooms().size(); i++) {
          executor.schedule(house :: collectFood, 3, TimeUnit.SECONDS);
        }
        executor.shutdown();

        while(!executor.awaitTermination(5, TimeUnit.SECONDS));
        for(Food food : house.getFoods()) {
            System.out.println(food.getFoodName());
        }
    }
}
