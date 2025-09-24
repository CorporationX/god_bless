package school.faang.bjs2_94777;

import java.util.List;

public class Magazine {
    List<Item> magazineItem = List.of(
            new Item("Boots", 25),
            new Item("Treads", 15),
            new Item("Tarrasque", 150),
            new Item("of Chaos", 35),
            new Item("Horn", 45),
            new Item("Fury", 35),
            new Item("King Bar", 35)
    );

    public Item getItem(int index) {
        return magazineItem.get(index);
    }
}
