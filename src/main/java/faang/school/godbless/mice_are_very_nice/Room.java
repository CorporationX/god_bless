package faang.school.godbless.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private final List<Food> foodList;
    private String room;

    public List<Food> collectFood() {
        List<Food> collected = new ArrayList<>(foodList);
        foodList.clear();
        return collected;
    }
}
