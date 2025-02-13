package school.faang.task_57407;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();


}
