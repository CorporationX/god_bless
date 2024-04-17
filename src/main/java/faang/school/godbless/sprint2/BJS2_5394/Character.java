package faang.school.godbless.sprint2.BJS2_5394;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Character {
    private final List<Item> inventory = new ArrayList<>();

    private String name;
}
