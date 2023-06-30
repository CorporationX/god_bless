package faang.school.godbless.Sprint_3.Multythreading;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foodInRoom;

    public void removeFood() {
        foodInRoom = new ArrayList<>();
    }
}
