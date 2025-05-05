package school.faang.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;

public record Room(List<Food> foods) {
    public Room {
        foods = new ArrayList<>(foods);
    }
}