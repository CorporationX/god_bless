package faang.school.godbless.BJS2_24994;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> shop = List.of(new Item("Sword", 10),
                new Item("Bow", 6),
                new Item("Axe", 12),
                new Item("Gun", 20)
        );

        List<Item> box = List.of(new Item("Dagger", 8),
                new Item("Boomerang", 7),
                new Item("Knife", 5),
                new Item("Shuriken", 4)
        );

        Inventory inventory = new Inventory();


    }
}
