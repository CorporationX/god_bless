package faang.school.godbless.task37;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data

public class Room {
    private String name;
    List<Food> food = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }
}
