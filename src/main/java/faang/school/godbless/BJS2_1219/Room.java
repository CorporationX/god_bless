package faang.school.godbless.BJS2_1219;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Room {
    private static int count = 0;
    private List<Food> foods;
    private int id;

    public Room(List<Food> foods) {
        this.foods = foods;
        id = ++count;
    }
}