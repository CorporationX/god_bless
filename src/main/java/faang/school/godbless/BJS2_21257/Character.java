package faang.school.godbless.BJS2_21257;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.function.Predicate;

@Getter
@Setter
@AllArgsConstructor
public class Character {

    private String name;
    private Set<Item> items;

    public boolean add(Item item) {
        return items.add(item);
    }

    public void removeIf(Predicate<? super Item> filter) {
        items.removeIf(filter);
    }

    public int size() {
        return items.size();
    }

}
