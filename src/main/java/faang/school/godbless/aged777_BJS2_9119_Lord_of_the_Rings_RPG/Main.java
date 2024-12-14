package faang.school.godbless.aged777_BJS2_9119_Lord_of_the_Rings_RPG;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*

    Условия задачи:
Описание: Вы являетесь разработчиком игры в сеттинге Средиземья, и вам поручено создать систему для управления
инвентарем персонажей «Властелина Колец». Ваша система должна позволять добавлять, удалять и изменять предметы в
инвентаре персонажей с использованием стандартных функциональных интерфейсов Java, таких как Function, Predicate и
Consumer.

Цель: Создайте класс InventoryManager с методами для управления инвентарем, которые принимают функциональные
интерфейсы Java. Продемонстрируйте использование этих методов для работы с инвентарем персонажей «Властелина Колец».

Требования:

Создайте класс Item с полями name и value;

Создайте класс Character с полем inventory, которое является списком объектов типа Item;

Создайте класс InventoryManager с методами:
addItem: принимает объект типа Character и объект типа Item, добавляет предмет в инвентарь персонажа и принимает
Consumer, который будет выполняться после успешного добавления предмета;
removeItem: принимает объект типа Character и объект типа Predicate<Item>, удаляет предмет из инвентаря персонажа,
если предмет удовлетворяет условию, заданному предикатом;
updateItem: принимает объект типа Character, объект типа Predicate<Item> и объект типа Function<Item, Item>, находит
предмет в инвентаре персонажа, который удовлетворяет условию, заданному предикатом, и обновляет его, применяя функцию.

Пример использования:

Character frodo = new Character("Frodo");
Item ring = new Item("The One Ring", 1000);

InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

// Удаляем предмет из инвентаря
manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

// Обновляем предмет в инвентаре
manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                          (item) -> new Item(item.getName(), item.getValue() * 2));

     */

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", 12));
        items.add(new Item("Item2", 13));
        items.add(new Item("Item3", 14));

        System.out.println("просто 3шт");
        System.out.println(items);

        Character frodo = new Character("Frodo", items);
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> {
            frodo.inventory().add(item);
            System.out.println(item.name() + " was added to the inventory.");
        });

        System.out.println(items);

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.value() == 13);

        System.out.println("Удалили где value = 13");
        System.out.println(items);

        // Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"), (item1) -> new Item(item1.name(), item1.value() + 10));

        System.out.println("Обновили где имя \"The One Ring\", value изменили на + 10");
        System.out.println("items " + items);
    }
}
