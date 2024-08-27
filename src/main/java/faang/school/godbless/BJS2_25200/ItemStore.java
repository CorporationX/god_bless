package faang.school.godbless.BJS2_25200;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class ItemStore {
    private List<Item> items;

    public Item combineItems(Item item1, Item item2) {
        if (item1.equals(item2)) {
            return item1;
        }

        Recipe recipe = item1.getRecipe();
        System.out.printf("Try combine %s and %s%n", item1, item2);

        if (recipe.getIngredients().contains(item2)) {
            return recipe.getResult();
        }
        return item1;
    }

    public synchronized Item removeItem() {
        int index = ThreadLocalRandom.current().nextInt(items.size());
        return items.remove(index);
    }
}
