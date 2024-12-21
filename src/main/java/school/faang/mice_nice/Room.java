package school.faang.mice_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private final String name;
    private List<Food> foods;

    public List<Food> collect() {
        List<Food> result = new ArrayList<>(foods);
        foods = new ArrayList<>();
        return result;
    }
}