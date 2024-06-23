package faang.school.godbless.mice_nice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Queue;

@Data
@AllArgsConstructor
public class Room {
    private String roomName;
    private Queue<Food> roomFoodList;
}
