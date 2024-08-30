package thread.eight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Room {

    private final List<Food> foodList = new ArrayList<>();


    public void addFood(@NonNull Food food) {
        foodList.add(food);
    }

}
