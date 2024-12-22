package school.faang.mice_nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@RequiredArgsConstructor
public class Room {
    private final List<Food> foods = new ArrayList<>();
    private final int number;

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
