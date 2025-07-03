package school.faang.bjs2_82718;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Item wood = new Item("Камень", 2);
        Item stick = new Item("Палка", 2);
        Item stone = new Item("Деревянный меч", 3);
        Item diamonds = new Item("Железный меч", 6);
        Item iron = new Item("Каменный меч", 5);

        Shop shop = new Shop(List.of(diamonds, iron));
        Chest chest = new Chest("Daily box", List.of(wood, stick, stone));

        ItemService itemService = new ItemService(chest, shop);
        Inventory inventory = new Inventory(new ArrayList<>());
        InventoryService inventoryService = new InventoryService(itemService);

        CompletableFuture<Item> combinedItem = inventoryService.combineItems(inventory);
        combinedItem.join();
        log.info("Инвентарь: {}", inventory.getItems());
    }
}
