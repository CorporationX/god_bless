package school.faang.BJS2_33773;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    String name;
    private List<Item> items;

    Character(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public void printItems() {
        System.out.println(name + "'s item list");
        for (Item i : items) {
            System.out.println(i);
        }
        System.out.println();
    }
}
