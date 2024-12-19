package school.faang.task_48324;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Room {
    private final String name;
    private final List<Food> foodList = new ArrayList<>();
}
