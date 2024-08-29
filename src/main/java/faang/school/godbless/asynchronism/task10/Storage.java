package faang.school.godbless.asynchronism.task10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Setter
@Getter
public class Storage {
    protected final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItem() {
        Random random = new Random();
        return items.size() > 0 ? items.get(random.nextInt(items.size())) : null;
    }
}
