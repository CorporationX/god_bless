package faang.school.godbless.BJS2_23780;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Setter
@Getter
public class House {
    private List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());
    private CountDownLatch latch;

    public void collectFood(List<Room> assignedRooms) {
        latch = new CountDownLatch(assignedRooms.size());
        assignedRooms.forEach(room -> {
            List<Food> food = room.collectFood();
            collectedFood.addAll(food);
            System.out.println("Собрали еду из комнаты: " + room.getName() + " - " + food);
            latch.countDown();
        });
    }
    public boolean allFoodCollected(List<Room> rooms) {
        if (latch != null) {
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return rooms.stream().allMatch(Room::isFoodListEmpty);
    }
}
