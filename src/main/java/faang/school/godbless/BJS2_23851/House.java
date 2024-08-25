package faang.school.godbless.BJS2_23851;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class House {
    private List<Room> rooms;
    private List<Food> foods = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood(List<Room> rooms) {
        for (Room room : rooms) {
            foods.addAll(room.getFoods());
            room.getFoods().clear();
        }
    }
}
