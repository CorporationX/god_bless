package faang.school.godbless.MiceAreNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class House {
    private List<Room> rooms;
    private List<Food> food;

    public void collectFood(int ind) {
        if (ind >= rooms.size()) {
            return;
        }
        food.addAll(rooms.get(ind).collectFood());
        if (++ind < rooms.size()) {
            food.addAll(rooms.get(ind).collectFood());
        }
    }
}
