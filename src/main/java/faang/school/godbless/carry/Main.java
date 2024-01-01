package faang.school.godbless.carry;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        extractingBox(inventory);
        extractingShop(inventory);
        CompletableFuture<Item> itemFromBox = inventory.getItemFromBox();
        CompletableFuture<Item> itemFromShop = inventory.getItemFromShop();
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> inventory.combineItems(itemFromBox.join(), itemFromShop.join()).thenCompose(item -> {
            inventory.addItem(item);
            return null;
        }));
        try {
            future.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
        System.out.println(inventory.getItems());
    }

    private static void extractingShop(Inventory inventory) {
        inventory.getItemsInShop().add(new Item("sword", 10));
        inventory.getItemsInShop().add(new Item("shield", 5));
        inventory.getItemsInShop().add(new Item("armor", 20));
    }

    private static void extractingBox(Inventory inventory) {
        inventory.getItemsInBox().add(new Item("sword", 10));
        inventory.getItemsInBox().add(new Item("shield", 5));
        inventory.getItemsInBox().add(new Item("armor", 20));
    }
}
/* в общем я знаю, что неправильно и будет куча вопросов "почему так? зачем тебе это?", поэтому напишу сразу.
Потому что я долго ломал голову в непонимании условия и почем требуется то, что требуется. Был бы признателен подсказкам,
что нужно сделать.
Вроде бы все должно асинхронно выполняться. Судя по выводу, оно так.
Не понимаю, зачем, создавать метод combineItems, когда есть thenCombine. Не понимаю, зачем использовать по условию метод
thenCompose, который возвращает что-то, для добавления элемента в инвентарь, когда это просто ничего не возвращающий метод добавления,
и вместо него можно использовать thenAccept и вывод будет тот же и возвращать ничего не надо будет.
 */