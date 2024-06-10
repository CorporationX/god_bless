package faang.school.godbless.lord_of_rings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Character {
    private List<Item> inventory = new ArrayList<>();
    private String name;

    public Character(String name) {
        this.name = name;
    }

    public void showInventory(){
        System.out.println("Inventory of " + name);
        inventory.forEach(System.out::println);
        System.out.println();
    }
}
