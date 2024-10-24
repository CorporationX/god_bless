package school.faang.java.thread1.tomdjerry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class InitData {
    public static List<Food> getFoodList(int room, int foodNumber) {
        List<Food> foodList = new ArrayList<>();
        for (int i = 0; i < foodNumber; i++) {
            foodList.add(new Food("Food Room " + room + " number " + i));
        }
        return foodList;
    }

    public static Map<Integer, Room> initRoomMap(int[] roomNumbers, int foodNumber) {
        Map<Integer, Room> roomMap = new HashMap<>();
        IntStream.range(0, roomNumbers.length).forEach(i -> {
            Room room = new Room();
            room.setFoodList(getFoodList(roomNumbers[i], foodNumber));
            roomMap.put(roomNumbers[i], room);
        });
        return roomMap;
    }
}