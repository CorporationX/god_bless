package school.faang.godbless.bjs2_36089;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private List<Food> foodList;

    public void clearFood() {
        foodList = new ArrayList<>();
    }
}
