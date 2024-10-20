package MultithreadingTomJerry;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class House {
    private List<Room> rooms;
    private List<Food> collectedFoods;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFoods = new ArrayList<>();
    }

    public void collectFood() {
        Random random = new Random();
        int counter = 2;

        while (counter != 0 && !allFoodsCollected()) {
            int randomNumber = random.nextInt(rooms.size());
            if (rooms.get(randomNumber).hasFood()) {
                Room selectedRoom = rooms.get(randomNumber);
                collectedFoods.addAll(selectedRoom.getFoods());
                selectedRoom.getFoods().clear();
                counter--;
                System.out.println("Foods collected from Room No. " + randomNumber);
            }
        }
    }

    public boolean allFoodsCollected() {
        return rooms.stream()
                .noneMatch(Room::hasFood);
    }
}