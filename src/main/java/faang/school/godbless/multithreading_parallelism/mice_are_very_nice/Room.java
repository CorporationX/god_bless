package faang.school.godbless.multithreading_parallelism.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;
}
