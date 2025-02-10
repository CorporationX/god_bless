package school.faang.sprint2.task_BJS2_57444;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Character {
    private String name;
    private final Set<Item> inventory = new HashSet<>();

}
