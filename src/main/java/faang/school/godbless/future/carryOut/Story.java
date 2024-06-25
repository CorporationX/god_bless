package faang.school.godbless.future.carryOut;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Data
@AllArgsConstructor
public class Story {

    private List<Item> itemsStore;

    public Item buyItem() {
        if (itemsStore.isEmpty()) {
            throw new NoSuchElementException("No items in store");
        }
        return itemsStore.get(new Random().nextInt(itemsStore.size()));
    }
}
