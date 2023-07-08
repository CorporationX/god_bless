package faang.school.godbless.sprint_3.Carry_eating;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item combine(Item first, Item second) {
        Item item = new Item();
        item.setName(first.getName() + " + " + second.getName());
        item.setPower(first.getPower() + second.getPower());
        return item;
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item();
            item.setName("Sword");
            item.setPower(10);
            return item;
        });
    }

    public CompletableFuture<Item> buy() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item();
            item.setName("Spear");
            item.setPower(20);
            return item;
        });
    }
}
/*
Задача:
В мире Dota 2, игроки собирают предметы,
которые могут быть скомбинированы для создания более мощных предметов.
Вам нужно написать программу, которая асинхронно собирает предметы и
комбинирует их в более сильные предметы.

Используйте методы thenCombine и thenCompose у CompletableFuture
для асинхронного получения предметов и их объединения.

Пример классов и предметов:

Класс Item — описывает предметы и их характеристики.
name — название предмета;
power — сила предмета.

Класс Inventory — описывает инвентарь игрока.
items — список предметов в инвентаре;
addItem(Item) — добавляет предмет в инвентарь;
combineItems(Item, Item) — комбинирует два предмета и создаёт новый с суммарной силой и
новым названием.

Создайте асинхронные методы, которые выполняют следующие действия:

Получение первого предмета из сундука.

Получение второго предмета из магазина.

Комбинирование предметов в более мощный предмет.
Т.е. выполняется, когда первые две операции выполнены,
как бы комбинируя их. Используем метод thenCombine из CompletableFuture.

Когда предметы скомбинированны, то нужно ещё асинхронно положить результирующий предмет
в инвентарь персонажа. Для этого используем метод thenCompose на результирующем
CompletableFuture после комбинирования,
запуская новую асинхронную задачу добавления предмета в инвентарь

Затем, добавьте полученный предмет в инвентарь игрока.
Используйте thenCombine и thenCompose для асинхронного выполнения этих действий и
обработки результата.
 */
