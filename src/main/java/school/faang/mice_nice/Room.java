package school.faang.mice_nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@Getter
@RequiredArgsConstructor
public class Room {
    private final List<Food> foods;

    public void addFood() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            foods.add(Food.getById(random.nextInt(7)));
        }
    }
}
