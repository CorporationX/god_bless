package faang.school.godbless.sprint3.BJS2_23798;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Room {
    private String name;
    private List<Food> food;

    public Room(String name, List<Food> food) {
        this.name = name;
        this.food = food;
    }
}
