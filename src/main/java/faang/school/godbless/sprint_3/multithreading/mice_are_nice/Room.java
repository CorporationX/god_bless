package faang.school.godbless.sprint_3.multithreading.mice_are_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Room {
    private String roomName;
    private List<Food> foodList;
}
