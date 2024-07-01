package faang.school.godbless.carry_overate;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Void> gettingCombinedItemFuture = inventory.getCombinedItem();

        inventory.getExecutorService().shutdown();

        gettingCombinedItemFuture.join();
        log.info("Current item list: " + inventory.getItems().toString());
    }
}
