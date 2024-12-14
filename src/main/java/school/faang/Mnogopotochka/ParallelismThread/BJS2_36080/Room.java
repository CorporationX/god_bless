package school.faang.Mnogopotochka.ParallelismThread.BJS2_36080;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private String roomName;
    private List<Food> foods = new ArrayList<>();

    Room(String name, List<String> foods) {
        this.roomName = name;
        for (String f : foods) {
            this.foods.add(new Food(f));
        }
    }
}
