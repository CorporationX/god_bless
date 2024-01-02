package faang.school.godbless.dota2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        //список товаров магазина
        List<Item> shop = List.of(
                new Item("Меч", 10),
                new Item("Кольчуга", 5),
                new Item("Кольцо", 15),
                new Item("Ботинки", 3)
        );

        //список инвентаря игрока
        List<Item> inventoryList = List.of(
                new Item("Дубина", 6),
                new Item("Щит", 8),
                new Item("Перчатки", 2)
        );

        //запуск потоков на получение предметов из магазина и инвентаря
        CompletableFuture<Item> itemFromInventoryFuture = inventory.getItemByInventory(inventoryList);
        CompletableFuture<Item> itemFromShopFuture = inventory.getItemByShop(shop);

        //ожидаем потоки с предметами, и запускаем метод combineItems
        var newFuture = itemFromInventoryFuture
                .thenCombine(itemFromShopFuture, (item1, item2) -> inventory.combineItems(item1, item2));


        //ждем завершения, и закрываем потоки
        try {
            newFuture.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            inventory.stopExecutorService();
        }
    }
}

@Data
@AllArgsConstructor
class Item {
    private String name;
    private int power;
}

@Data
class Inventory {
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private List<Item> items;

    public void addItem(Item item) {
        System.out.println("Добавили предмет в инвентарь!");
        items.add(item);
    }

    public CompletableFuture<Item> getItemByInventory(List<Item> list) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Получаем предмет из инвенторя! " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }, executorService);
    }

    public CompletableFuture<Item> getItemByShop(List<Item> list) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Получаем предмет из магазина! " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }, executorService);

    }

    //как понял я, игрок пришел в магазин, купил какой-то предмет, у него свой предмет улучшился и он его положил к себе в инвентарь.
    //поэтому метод комбинирования у меня сразу добавляет его в инвентарь игрока
    public CompletableFuture<Item> combineItems(Item item1, Item item2) {
        return CompletableFuture.supplyAsync(() -> item1)
                .thenCombine(CompletableFuture.supplyAsync(() -> item2),
                        (i1, i2) -> {
                            Item newItem = new Item("upgrade: " + i1.getName().toUpperCase() + " - " + i2.getName().toUpperCase(), item1.getPower() + item2.getPower());
                            System.out.println("Метод combineItems в потоке: " + Thread.currentThread().getName());
                            System.out.println("Предмет " + newItem.getName() + " power = " + newItem.getPower());
                            return newItem;
                        })
                .thenCompose(newItem -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("Добавление в инвентарь, в потоке " + Thread.currentThread().getName());
                    addItem(newItem);
                    return newItem;
                }, executorService));
    }

    public void stopExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}