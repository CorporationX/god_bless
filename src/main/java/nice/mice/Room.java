package nice.mice;

import java.util.List;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Room {
    List<Food> foodList;

    public void removeAllFood() {
        foodList.clear();
    }

    public boolean hasFood() {
        return !foodList.isEmpty();
    }
}
