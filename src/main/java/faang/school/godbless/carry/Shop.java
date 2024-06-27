package faang.school.godbless.carry;

import java.util.List;
import java.util.Random;

public class Shop {
    Random rand = new Random();
    private List<Item> allItems = List.of(
            new Item("Blink Dagger", 10),
            new Item("Black King Bar", 30),
            new Item("Aghanim's Scepter", 25),
            new Item("Desolator", 20),
            new Item("Manta Style", 15),
            new Item("Daedalus", 35)
    );

    public Item buyItem() {
        return allItems.get(rand.nextInt(allItems.size()));
    }
}
