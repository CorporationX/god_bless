package faang.school.godbless.Mice.are.very.nice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Room {

    private int roomID;
    private List<Food> foods;
    private boolean isEmpty = false;

    public Room(int roomID, List<Food> foods) {
        this.roomID = roomID;
        this.foods = foods;
    }
}
