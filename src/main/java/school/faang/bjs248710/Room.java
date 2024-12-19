package school.faang.bjs248710;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Room {
    private static final Logger LOGGER = LoggerFactory.getLogger(Room.class);
    private final List<Food> foods = new ArrayList<>();

    public Room(List<Food> foods) {
        this.foods.addAll(foods);
    }

    public List<Food> collectFoods() {
        List<Food> copy = new ArrayList<>(foods);
        foods.clear();
        LOGGER.info("Food collected = {}", copy);
        return copy;
    }
}
