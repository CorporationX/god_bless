package faang.school.godbless.sprint_3.task_48727;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private final List<Food> allFood = new ArrayList<>();

    public void addFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Еда не может быть null");
        }
        allFood.add(food);
    }

    public boolean containsFood() {
        if (allFood.isEmpty()) {
            System.out.println("В комнате нет еды");
            return false;
        }
        return true;
    }

    public void removeAllFood() {
        allFood.clear();
    }
}
