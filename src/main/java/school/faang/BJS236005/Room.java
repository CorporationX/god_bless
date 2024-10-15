package school.faang.BJS236005;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private String name;
    private List<Food> foods = new ArrayList<>();

    Room(String name, List<String> foods) {
        this.name = name;
        for (String f : foods) {
            this.foods.add(new Food(f));
        }
    }
}
