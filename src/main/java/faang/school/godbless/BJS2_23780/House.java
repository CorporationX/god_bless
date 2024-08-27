package faang.school.godbless.BJS2_23780;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


@Setter
@Getter
public class House {
    private Queue<Food> collectedFood = new ConcurrentLinkedQueue<>();
    private List<Room> rooms = new ArrayList<>();

    public void collectFood(List<Room> assignedRooms) {
        assignedRooms.forEach(room -> {
            List<Food> food = room.collectFood();
            collectedFood.addAll(food);
            System.out.println("Собрали еду из комнаты: " + room.getName() + " - " + food);
        });
    }
}
