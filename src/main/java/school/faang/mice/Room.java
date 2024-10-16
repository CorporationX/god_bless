package school.faang.mice;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Room {
    private final List<Food> foodList;

    public List<Food> removeAllFood() {
        List<Food> result = List.copyOf(foodList);
        foodList.clear();
        System.out.println("Комната очищена");
        return result;
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
