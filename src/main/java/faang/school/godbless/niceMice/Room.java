package faang.school.godbless.niceMice;

import lombok.Data;

import java.util.List;

@Data
public class Room {
    private String name;
    private List<Food> food;
    private boolean isCollected = false;

    public Room(String name, List<Food> food) {
        this.name = name;
        this.food = food;
    }
}
