package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Mice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foodInRoom;

    public void removeFood() {
        foodInRoom.clear();
    }
}
