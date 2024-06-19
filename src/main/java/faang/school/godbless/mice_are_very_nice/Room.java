package faang.school.godbless.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Room {
    private String name;
    private List<Food> foods;
}
