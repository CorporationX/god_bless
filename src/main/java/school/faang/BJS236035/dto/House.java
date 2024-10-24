package school.faang.BJS236035.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Data
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFoods;
    private Random random;

    public House(int sumRooms) {
        this.rooms = new ArrayList<>();
        this.collectedFoods = new ArrayList<>();
        this.random = new Random();
        this.initialize(sumRooms);
    }

    private void initialize(int sumRooms) {
        for (int i = 1; i <= sumRooms; i++) {
            this.getRooms().add(new Room(i));
        }
    }

    public boolean allFoodCollected() {
        return this.getRooms().stream()
                .noneMatch(Room::hasFood);
    }

    public void collectFood() {
        this.deleteFood(random.nextInt(this.getRooms().size()));
        this.deleteFood(random.nextInt(this.getRooms().size()));
    }

    private void deleteFood(int numberRoom) {
        Room room = this.getRooms().get(numberRoom);
        if (room.hasFood()) {
            this.getCollectedFoods().addAll(room.getFoods());
            room.removeAllFoods();
        }
    }
}
