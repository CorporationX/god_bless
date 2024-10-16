package school.faang.sprint_3.bjs2_36099_miceAreVeryNice;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Room {
    private List<Food> foodList;

    public List<Food> getFoodList() {
        return List.copyOf(foodList);
    }

    public void removeAllFood() {
        foodList.clear();
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
