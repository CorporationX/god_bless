package school.faang.task_48253;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final Random rand = new Random();
    private final List<Food> collectedFoods = new ArrayList<>();


    public void collectFood() {

        while (true) {
            int r1Index = rand.nextInt(0, rooms.size());
            int r2Index = rand.nextInt(0, rooms.size());

            if (r1Index == r2Index) {
               continue;
            }

            Room room1 = rooms.get(r1Index);
            Room room2 = rooms.get(r2Index);

            if (room1.getLock().tryLock() && room2.getLock().tryLock()) {
                try {
                    collectedFoods.addAll(room1.getFoods());
                    room1.getFoods().clear();

                    collectedFoods.addAll(room2.getFoods());
                    room2.getFoods().clear();

                    break;
                } finally {
                    room1.getLock().unlock();
                    room2.getLock().unlock();
                }
            }
        }
    }
}
