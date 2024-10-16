package school.BJS2_36058;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Getter
public class House {

    private List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private volatile CountDownLatch latch;

    public House(CountDownLatch latch) {
        this.latch = latch;
    }

    public boolean isAll() {
        for (Room room : rooms) {
            if (!room.hasFood()) {
                return true;
            }
        }
        return false;
    }

    public void collectFood() {
        Random rand = new Random();
        Room room1 = rooms.get(rand.nextInt(rooms.size()));
        Room room2 = rooms.get(rand.nextInt(rooms.size()));
        if (room1.hasFood() || room2.hasFood()) {
            room1.getFoods(collectedFood, this);
            room2.getFoods(collectedFood, this);
        }
    }
}