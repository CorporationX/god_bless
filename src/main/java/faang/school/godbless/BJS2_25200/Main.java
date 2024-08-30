package faang.school.godbless.BJS2_25200;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Item> storeItems = new ArrayList<>(List.of(
                BladesOfAttack.BLADES_OF_ATTACK,
                Claymore.CLAYMORE,
                DemonEdge.DEMON_EDGE,
                Crystalis.CRYSTALIS
        ));
        ItemStore store = new ItemStore(storeItems);

        List<Item> inventoryItems = new ArrayList<>(List.of(
                DemonEdge.DEMON_EDGE,
                Claymore.CLAYMORE
        ));
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Inventory inventory = new Inventory(executor, inventoryItems);

        System.out.println("Было в инвентаре: " + inventoryItems);
        System.out.println();
        IntStream.range(0, storeItems.size())
                .forEach(i -> inventory.addItem(store));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println();
        System.out.println("Стало в инвентраре: " + inventoryItems);
    }
}
