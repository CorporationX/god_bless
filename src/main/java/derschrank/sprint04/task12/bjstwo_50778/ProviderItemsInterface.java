package derschrank.sprint04.task12.bjstwo_50778;

import java.util.List;
import java.util.Optional;

public interface ProviderItemsInterface {
    void addItem(Item item);

    Optional<Item> getItem(int index);

    List<Item> getListOfItems();

    int getCountOfItems();
}
