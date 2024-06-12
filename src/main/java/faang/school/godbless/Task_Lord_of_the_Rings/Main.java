package faang.school.godbless.Task_Lord_of_the_Rings;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Item shield = new Item("Shield", 10);
        Item weapon = new Item("Hammer", 5);
        Item ring = new Item("Ring", 7);
        Character thrall = new Character("Thrall", new ArrayList<>(Arrays.asList(shield, weapon)));
        InventoryManager jivs = new InventoryManager();
        jivs.addItem(thrall, ring, (item)->System.out.println(item.getName() + "was added to the inventory"));
        thrall.showInventory();
        jivs.removeItem(thrall, (item)->item.getName().equals("Ring"));
        thrall.showInventory();
        jivs.updateItem(thrall, (item)->item.getName().equals("Hammer"),
                (item)->new Item(item.getName(), item.getValue()*2));
        thrall.showInventory();

    }
}
