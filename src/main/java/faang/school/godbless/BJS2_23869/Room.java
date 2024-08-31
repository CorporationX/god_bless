package faang.school.godbless.BJS2_23869;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor
@Getter
public class Room {

    private final List<Food> foodInRoom;

    public List<Food> collectFood() {
        List<Food> collectedFood = new ArrayList<>(foodInRoom);
        foodInRoom.clear();
        return collectedFood;
    }
}
