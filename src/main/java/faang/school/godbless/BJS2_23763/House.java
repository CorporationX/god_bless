package faang.school.godbless.BJS2_23763;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();

    public synchronized void collectFood(Room roomOne, Room roomTwo) {
        Food foodOne = roomOne.getFood();
        collectedFood.add(foodOne);
        Food foodTwo = roomTwo.getFood();
        collectedFood.add(foodTwo);

        System.out.println(foodOne + " and " + foodTwo + " collected");
    }

    public synchronized List<List<Room>> createRoomsPair() {
        List<Room> roomsWithFood = rooms.stream()
                .flatMap(room -> room.getFoods().stream().map(food -> room))
                .toList();
        return IntStream.iterate(0, i -> i < roomsWithFood.size(), i -> i + 2)
                .mapToObj(i -> Arrays.asList(roomsWithFood.get(i), roomsWithFood.get(i + 1)))
                .toList();
    }
}

