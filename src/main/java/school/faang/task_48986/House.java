package school.faang.task_48986;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private static final int ROOMS_QUANTITY_FOR_COLLECT_FOOD = 2;

    private final List<Room> rooms;
    private final List<Food> foods;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.foods = new ArrayList<>();
    }

    protected List<Room> selectedRooms() {
        Random random = new Random();
        List<Room> shuffledRooms = new ArrayList<>(rooms);
        Collections.shuffle(shuffledRooms, random);
        return shuffledRooms.subList(0, ROOMS_QUANTITY_FOR_COLLECT_FOOD);
    }
}
