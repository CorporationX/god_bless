package school.faang.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    List<Room> roomsList = new ArrayList<>();
    static final List<Food> collectedFood = new ArrayList<>();
    Random random = new Random();

    public void collectFood() {
        boolean flag = false;
        for (Room room : roomsList) {
            if (!room.foodList().isEmpty()) {
                flag = true;
                break;
            }
        }
        if (flag) {
            int i = 0;
            while (i < 2) {
                i++;
                int roomNumber = random.nextInt(roomsList.size());
                List<Food> temporaryFoodList = roomsList.get(roomNumber).foodList();

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
