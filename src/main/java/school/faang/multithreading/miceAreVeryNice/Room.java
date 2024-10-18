package school.faang.multithreading.miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    private List<Food> foodList;

    public boolean hasFood() {
        return !foodList.isEmpty();
    }

    public void removeAllFood() {
        foodList.clear();
    }

}
