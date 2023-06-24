package faang.school.godbless.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        if(this.inventory == null) {
            this.inventory = new ArrayList<>();
        }
        this.name = name;
    }
}
