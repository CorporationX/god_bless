package school.faang.task_48704;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private String name;
    private List<Food> foods;

    public Room(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
    }
}
