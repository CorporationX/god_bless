package school.faang.BJS2_36098;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private List<Food> food;

    public Room(List<Food> food) {
        this.food = food;
    }
}
