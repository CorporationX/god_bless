package faang.school.godbless.miceNice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Room {
    private List<Food> food;

    public Room() {
        food = new ArrayList<>();
    }
}
