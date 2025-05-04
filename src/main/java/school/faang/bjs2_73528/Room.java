package school.faang.bjs2_73528;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Room {
    private final List<Food> foods;

    public synchronized boolean hasFood() {
        return !foods.isEmpty();
    }

    public synchronized List<Food> collectAndClearFood() {
        List<Food> collected = new ArrayList<>(foods);
        foods.clear();
        return collected;
    }
}
