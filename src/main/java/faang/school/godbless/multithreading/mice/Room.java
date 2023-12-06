package faang.school.godbless.multithreading.mice;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Room {
    private String name;
    private List<Food> foodList;
}
