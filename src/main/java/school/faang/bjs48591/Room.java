package school.faang.bjs48591;

import lombok.Getter;
import java.util.List;

public record Room(@Getter int number, List<Food> foodList) {
    @Override
    public List<Food> foodList() {
        return List.copyOf(foodList);
    }

    public void clearRoom() {
        foodList.clear();
    }
}
