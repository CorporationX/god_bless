package faang.school.godbless.mice_nice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String roomName;
    private List<Food> roomFoodList;
}
