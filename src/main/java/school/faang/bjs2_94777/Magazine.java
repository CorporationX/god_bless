package school.faang.bjs2_94777;

import java.util.List;

public class Magazine {
    List<Item> magazine = List.of(
            new Item("Boots", 25),
            new Item("Treads", 15),
            new Item("Tarrasque", 150),
            new Item("of Chaos", 35),
            new Item("Horn", 45),
            new Item("Fury", 35),
            new Item("King Bar", 35)
    );

    public Item getMagazineItem(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше нуля!");
        }
        return magazine.get(index);
    }
}
