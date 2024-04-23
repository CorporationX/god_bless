package miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private int number;
    private List<Food> foodsInRoom;

    public void updateFoodList() {
        foodsInRoom = new ArrayList<>();
    }
}
