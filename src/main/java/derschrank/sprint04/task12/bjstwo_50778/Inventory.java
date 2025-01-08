package derschrank.sprint04.task12.bjstwo_50778;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventory implements WorkshopInterface {
    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void buyItem(ProviderItemsInterface shop, int index) {
        Optional<Item> itemOpt = shop.getItem(index);
        itemOpt.ifPresent(item -> {
            addItem(item);
            System.out.println("Item was bought: " + item);
        }
        );
    }

    @Override
    public synchronized void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    @Override
    public synchronized Optional<Item> getItem(int index) {
        if (index < items.size()) {
            return Optional.of(items.remove(index));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Item> getFirst() {
        return getItem(0);
    }

    @Override
    public synchronized List<Item> getListOfItems() {
        return new ArrayList<>(items);
    }

    @Override
    public int getCountOfItems() {
        return items.size();
    }

    @Override
    public Item combineItems(Item itemOne, Item itemTwo) {
        if (itemTwo == null) {
            return itemOne;
        }
        if (itemOne == null) {
            return itemTwo;
        }

        return new Item(itemOne.name() + "+" + itemTwo.name(),
                itemOne.power() + itemTwo.power());
    }
}
