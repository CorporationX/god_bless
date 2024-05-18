package faang.school.godbless.mice.are.very.nice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Room {
    private final List<Food> foods = new ArrayList<>();
}
