package faang.school.godbless.BJS2_11785;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Room {
    private String name;
    private List<Food> foods;
}
