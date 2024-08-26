package mice.are.very.nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private final List<Food> collectedFood = new ArrayList<>();
    private final List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood(List<Room> rooms) {
        rooms.forEach(room -> {
            System.out.printf("Начали сбор еды из комнаты: %s\n", room.getName());
            this.collectedFood.addAll(room.getFoods());
            room.getFoods().clear();
            System.out.printf("Собрали всю еду из комнаты: %s\n", room.getName());
        });
    }
}
