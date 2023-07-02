package faang.school.godbless.MiceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private int roomNumber;
    private List<Food> foodList;
}
