package school.faang.task_45509;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Getter
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItemByCondition(Predicate<Item> condition) {
        inventory.removeIf(condition);
    }
}
