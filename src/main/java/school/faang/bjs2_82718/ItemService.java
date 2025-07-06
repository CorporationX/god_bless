package school.faang.bjs2_82718;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class ItemService {
    private static final int PROCESS_CHEST_IN_SEC = 2;
    private static final int PROCESS_SHOP_IN_SEC = 4;
    private static final int IND_SECOND_ITEM = 1;
    private Chest chest;
    private Shop shop;

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(PROCESS_CHEST_IN_SEC);
                } catch (InterruptedException e) {
                    log.error("Поток прервался во время открывания сундука", e);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                return chest.getFirst()
                        .orElseThrow(() -> new NoSuchElementException("В сундуке нет предметов"));
            }
        );
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(PROCESS_SHOP_IN_SEC);
                } catch (InterruptedException e) {
                    log.error("Поток прервался во время покупки в магазине", e);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                return shop.get(IND_SECOND_ITEM)
                        .orElseThrow(() -> new NoSuchElementException("В магазине нет предметов"));
            }
        );
    }
}
