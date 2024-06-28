package faang.school.godbless.sprint2.mice;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Evgenii Malkov
 */
@Getter
@AllArgsConstructor
public class Room {
    private int roomNumber;
    private List<Food> food;
}
