package faang.school.godbless.sprint.three.mice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;
}
