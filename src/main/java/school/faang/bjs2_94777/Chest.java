package school.faang.bjs2_94777;

import lombok.Getter;

import java.util.List;

@Getter
public class Chest {
    private final List<Item> chest = List.of(
            new Item("Phase", 20),
            new Item("Power", 25),
            new Item("Heart", 100),
            new Item("Blade", 30),
            new Item("Satanic", 40),
            new Item("Battle", 35),
            new Item("Crystalys", 28),
            new Item("Monkey", 45)
    );

    public Item getChestItem(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше нуля!");
        }
        return chest.get(index);
    }
}
