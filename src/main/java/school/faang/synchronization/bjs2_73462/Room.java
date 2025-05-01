package school.faang.synchronization.bjs2_73462;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@ToString
public class Room {
    @Getter
    private final int number;
    private final List<Food> foods;

    public List<Food> clearFood() {
        var collectedFood = new ArrayList<>(foods);
        foods.clear();
        return collectedFood;
    }
}
