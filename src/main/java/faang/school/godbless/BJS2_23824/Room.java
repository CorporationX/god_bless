package faang.school.godbless.BJS2_23824;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Room {
    private final String name;
    private List<Food> foods = new ArrayList<>();
}
