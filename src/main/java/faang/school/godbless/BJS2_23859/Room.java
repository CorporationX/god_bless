package faang.school.godbless.BJS2_23859;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private String name;
    private final List<Food> FOOD = new ArrayList<>();
}