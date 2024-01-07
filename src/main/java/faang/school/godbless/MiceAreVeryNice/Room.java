package faang.school.godbless.MiceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foodsInRoom;
}
