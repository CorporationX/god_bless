package faang.school.godbless.sprint3.Mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> food;
}
