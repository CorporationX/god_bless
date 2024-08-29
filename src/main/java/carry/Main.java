package carry;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        var store = initStore();
        var chest = initChest();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = chest.size(); i > 0; i--) {
            futures.add(getItemFromChest(chest)
                    .thenCombine(getItemFromStore(store), inventory::combineItem)
                    .thenCompose(r -> CompletableFuture.runAsync(() -> inventory.addItem(r))));
        }
        futures.forEach(CompletableFuture::join);
        inventory.printAllItems();
    }

    private static CompletableFuture<Item> getItemFromChest(@NonNull List<Item> chest) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (Main.class) {
                return chest.remove(ThreadLocalRandom.current().nextInt(chest.size()));
            }
        });
    }

    private static CompletableFuture<Item> getItemFromStore(@NonNull List<Item> store) {
        return CompletableFuture.supplyAsync(() -> {
            Item item = store.get(ThreadLocalRandom.current().nextInt(store.size()));
            return new Item(item.getName(), item.getPower());
        });
    }

    private static List<Item> initStore() {
        return List.of(
                new Item("Orb of Venom", 250),
                new Item("Shadow Amulet", 1000),
                new Item("Magic Stick", 200),
                new Item("Iron Branch", 250),
                new Item("Sage's Mask", 175),
                new Item("Point Booster", 1200),
                new Item("Javelin", 900),
                new Item("Reaver", 2800),
                new Item("Sacred Relic", 3400),
                new Item("Broadsword", 1000));
    }

    private static List<Item> initChest() {
        return new ArrayList<>(List.of(
                new Item("Gem of True Sight", 900),
                new Item("Band of Elvenskin", 450),
                new Item("Boots of Speed", 450),
                new Item("Crown", 450),
                new Item("Staff of Wizardry", 175),
                new Item("Ring of Health", 700),
                new Item("Circlet", 155),
                new Item("Ring of Tarrasque", 1800),
                new Item("Chainmail", 550),
                new Item("Helm of Iron Will", 975)));
    }
}
