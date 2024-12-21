package school.faang.bjs248710;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Slf4j
public class Room {
    private final List<Food> foods = new ArrayList<>();

    public Room(List<Food> foods) {
        this.foods.addAll(foods);
    }

    public List<Food> collectFoods() {
        List<Food> copy = new ArrayList<>(foods);
        foods.clear();
        log.info("Food collected = {}", copy);
        return copy;
    }
}
