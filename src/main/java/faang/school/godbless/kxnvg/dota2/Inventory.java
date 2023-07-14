package faang.school.godbless.kxnvg.dota2;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Getter
public class Inventory {

    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @SneakyThrows
    public int combineItems(Item item1, Item item2) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Получаем предмет " + item1.getName() + " из сундука");
            return item1.getPower();})

                .thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("Получаем предмет " + item2.getName() + " из магазина");
            return item2.getPower();}), (x, y) -> x.intValue() + y.intValue())

                .thenCompose(x -> {
            int power = x.intValue();
            return CompletableFuture.supplyAsync(() -> {
                String newName = "super" + item1.getName() + item2.getName();
                addItem(new Item(newName, power));
                System.out.println("Новый предмет: " + newName + " с общей силой " + power + " добавлен в портфель пользователя");
                return power;
            });
        });

        return future.get();
    }
}
