package school.faang.carryFeed;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Getter
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        return item1.combineWith(item2);
    }

    public void initializeRandomItems(int numItems) {
        Random random = new Random();
        List<String> itemNames = List.of("Blink Dagger", "Aghanim's Scepter", "Black King Bar", "Butterfly",
                "Eul's Scepter of Divinity", "Hand of Midas", "Manta Style", "Divine Rapier", "Shadow Blade",
                "Desolator", "Arcane Boots", "Force Staff", "Heart of Tarrasque", "Hood of Defiance", "Lotus Orb",
                "Radiance", "Shiva's Guard", "Bloodstone", "Monkey King Bar", "Eye of Skadi");
        List<ItemType> types = List.of(ItemType.SHOP, ItemType.CHEST);
        for (int i = 0; i < numItems; i++) {
            items.add(new Item(
                    itemNames.get(random.nextInt(itemNames.size())),
                    types.get(random.nextInt(types.size())),
                    random.nextInt(0, 100))
            );
        }
    }

    public synchronized List<Item> pickItemsByType(ItemType type) {
        return items.stream()
                .filter(item -> item.getType().equals(type))
                .toList();
    }

    public CompletableFuture<Item> getItemByTypeAndRemove(ItemType type) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            List<Item> availableItems = pickItemsByType(type);
            if (availableItems.isEmpty()) {
                throw new RuntimeException("No items of type " + type + " left!");
            }
            Item selectedItem = availableItems.get(0);
            items.remove(selectedItem);
            return selectedItem;
        });
    }
}
