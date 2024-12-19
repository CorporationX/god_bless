package school.faang.mice_nice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class Room {
    private final List<Food> foods = new ArrayList<>();
    private final int number;

    public void addFood() {
        Random random = new Random();
        for (int i = 0; i < DataSet.AMOUNT_OF_FOODS_IN_ROOMS; i++) {
            foods.add(Food.getById(random.nextInt(Food.values().length + 1)));
        }
    }

    public List<Food> removeAllFood() {
        List<Food> foodWasInRoom = new ArrayList<>(foods);
        log.info("Room {} served", this.number);
        foods.clear();
        return foodWasInRoom;
    }

    public boolean hasFood() {
        return !foods.isEmpty();
    }
}
