package school.faang.BJS236035.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Data
@Slf4j
public class Room {
    private final Integer numberRoom;
    private final List<Food> foods;

    public static final Integer COUNT_FOODS = 10;
    public static final String FOOD_NAME_DEFAULT = "noNameFood";

    public Room(int numberRoom) {
        this.numberRoom = numberRoom;
        this.foods = new ArrayList<>();
        this.addFood();
    }

    private void addFood() {
        for (int i = 0; i < Room.COUNT_FOODS; i++) {
            this.getFoods().add(new Food(FOOD_NAME_DEFAULT));
        }
    }

    public void removeAllFoods() {
        this.getFoods().clear();
        log.debug("Room #{} hasn't any food", this.getNumberRoom());
    }

    public boolean hasFood() {
        return Objects.nonNull(this.getFoods()) && !(this.getFoods().isEmpty());
    }
}
