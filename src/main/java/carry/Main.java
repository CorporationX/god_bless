package carry;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int POOL_SIZE = 50;

    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        var store = initStore();
        var chest = initChest();
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            while (!chest.isEmpty()) {
                CompletableFuture.supplyAsync(() -> getItemFromChest(chest), executor)
                        .thenCombine(CompletableFuture.supplyAsync(() -> getItemFromStore(store)),
                                inventory::combineItem)
                        .thenCompose(r -> CompletableFuture.runAsync(() -> inventory.addItem(r)));
            }
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Finished");
            } else {
                log.error("Time out");
            }
        }
        inventory.printAllItems();
    }

    private static synchronized Item getItemFromChest(@NonNull List<Item> chest) {
        return chest.remove(ThreadLocalRandom.current().nextInt(chest.size()));
    }

    private static Item getItemFromStore(@NonNull List<Item> store) {
        Item item = store.get(ThreadLocalRandom.current().nextInt(store.size()));
        return new Item(item.getName(), item.getPower());
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
