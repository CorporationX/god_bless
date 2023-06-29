package faang.school.godbless.mice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private int roomId;
    private List<Food> foodList;
}
