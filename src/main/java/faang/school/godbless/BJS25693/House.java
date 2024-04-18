package faang.school.godbless.BJS25693;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public synchronized void collectFood() {
        System.out.println(Thread.currentThread().getName() + " начал сбор еды.");
        for (Room room : rooms) {
            collectedFood.addAll(room.getFoods());
            room.getFoods().clear();
        }
        System.out.println(Thread.currentThread().getName() + " закончил сбор еды.");
    }
}
