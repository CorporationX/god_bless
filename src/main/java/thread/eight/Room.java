package thread.eight;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private List<Food> foodList = new ArrayList<>();

    public void addFood(@NonNull Food food) {
        foodList.add(food);
    }

}
