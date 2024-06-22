package faang.school.godbless.BJS211809;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Room {
    private int roomId;
    private List<Food> foods;

}
