package faang.school.godbless.MiceAreNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class House {
    private List<Room> rooms;
    private List<Food> food;

    public void collectFood(int initialInd) {
        if (initialInd >= rooms.size()) {
            return;
        }
        food.addAll(rooms.get(initialInd).collectFood());
        if (++initialInd < rooms.size()) {
            food.addAll(rooms.get(initialInd).collectFood());
        }
    }
}
