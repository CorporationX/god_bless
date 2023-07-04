package faang.school.godbless.kxnvg.tomandjerry;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Room {

    private String name;
    private List<Food> roomFood;

    public Room(String name) {
        this.name = name;
    }
}
