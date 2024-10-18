package school.faang.miceverynice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    List<Room> roomsList = new ArrayList<>();
    static final List<Food> collectedFood = new ArrayList<>();
    Random random = new Random();

    public void collectFood() {

        boolean flag = roomsList.stream().anyMatch(room -> !room.foodList().isEmpty());

        if (flag) {
            int i = 0;
            while (i < 2) {
                i++;
                int roomNumber = random.nextInt(roomsList.size());
                Room room = roomsList.get(roomNumber);
                synchronized (room) {
                    List<Food> temporaryFoodList = room.foodList();

                    if (temporaryFoodList.isEmpty()) {
                        continue;
                    }
                    synchronized (collectedFood) {
                        collectedFood.addAll(temporaryFoodList);
                    }
                    roomsList.get(roomNumber).foodList().clear();
                }
            }
        }
    }
}
