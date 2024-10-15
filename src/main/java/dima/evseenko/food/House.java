package dima.evseenko.food;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> houseFood = new ArrayList<>();

    public void collectFood() {
        int randomFirstRoomIndex = new Random().nextInt(rooms.size());
        int randomSecondRoomIndex = new Random().nextInt(rooms.size());

        while (randomSecondRoomIndex == randomFirstRoomIndex) {
            randomSecondRoomIndex = new Random().nextInt(rooms.size());
        }

        houseFood.addAll(rooms.get(randomFirstRoomIndex).getFoods());
        rooms.get(randomFirstRoomIndex).getFoods().removeAll(houseFood);

        houseFood.addAll(rooms.get(randomSecondRoomIndex).getFoods());
        rooms.get(randomSecondRoomIndex).getFoods().removeAll(houseFood);
    }
}
