package faang.school.godbless.multithreading.parallelism_thread.walmart;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int id;
    private String name;
    private int price;
    public static List<Item> items = new ArrayList<>();

    public Item(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Item getById(int id) {
        Item item = null;
        for (Item i : items) {
            if (i.id == id) {
                item = i;
                break;
            }
        }
        return item;
    }

    public int getPrice() {
        return price;
    }
}
