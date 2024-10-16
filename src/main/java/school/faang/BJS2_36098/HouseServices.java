package school.faang.BJS2_36098;

import java.util.List;

public class HouseServices {
    public void collectFood(List<Room> checkingRooms) {
        List<Food> food = checkingRooms.stream()
                .flatMap(room -> {
                    List<Food> foodInRoom = room.getFood();
                    List<Food> removeFood = List.copyOf(foodInRoom);
                    foodInRoom.clear();
                    return removeFood.stream();
                })
                .toList();
    }
}
