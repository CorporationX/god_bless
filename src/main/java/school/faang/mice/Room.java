package school.faang.mice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private List<Food> foods;

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    public void removeAllFood() {
        foods.clear();
    }
}
