package school.faang.bjs2_94777;

import java.util.List;

public class Chest {
    List<Item> storageList = List.of(
            new Item("Phase", 20),
            new Item("Power", 25),
            new Item("Heart", 100),
            new Item("Blade", 30),
            new Item("Satanic", 40),
            new Item("Battle", 35),
            new Item("Crystalys", 28),
            new Item("Monkey", 45)
    );

    public Item getItem(int index) {
        return  storageList.get(index);
    }

    public void addStorage(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Предмет не может быть пустым");
        }
        storageList.add(item);
    }
}
