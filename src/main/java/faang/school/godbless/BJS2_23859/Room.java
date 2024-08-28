package faang.school.godbless.BJS2_23859;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Room {
    private String name;
    private List<Food> food;

    public Room(String name) {
        this.name = name;
        this.food = new ArrayList<>();
    }
}