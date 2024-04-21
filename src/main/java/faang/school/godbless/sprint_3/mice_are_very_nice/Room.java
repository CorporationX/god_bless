package faang.school.godbless.sprint_3.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private List<Food> foods;
}