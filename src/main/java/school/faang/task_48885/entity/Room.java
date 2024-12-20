package school.faang.task_48885.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class Room {
    private final List<Food> foodList = new ArrayList<>();
    private final AtomicBoolean isProcessing = new AtomicBoolean(false);
    private final AtomicBoolean isCleared = new AtomicBoolean(false);

    public void addFood(Food food) {
        if (food == null) {
            throw new NullPointerException("food");
        }
        foodList.add(food);
    }

    public void startCleaning() {
        isProcessing.compareAndSet(false, true);
    }

    public void finishCleared() {
        isProcessing.set(false);
        isCleared.set(true);
    }

    public boolean isAvailable() {
        return !isProcessing.get() && !isCleared.get();
    }
}
