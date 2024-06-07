package faang.school.godbless.module.second.lambda.rings;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private final String name;
    
    public Character(String name) {
        this.name = name;
    }
    
    public void showInventory() {
        System.out.printf("Инвентарь %s:\n", name);
        inventory.forEach((item -> System.out.println(item)));
    }
}
