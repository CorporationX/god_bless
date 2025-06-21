package school.faang.sprint3.bjs2_81850;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Room {
    @NonNull
    private final int id;
    @NonNull
    private final List<Food> food;

    public boolean hasFood() {
        return !food.isEmpty();
    }

    public synchronized List<Food> getAllFood() {
        List<Food> result = new ArrayList<>(food);
        food.clear();
        return result;
    }
}
