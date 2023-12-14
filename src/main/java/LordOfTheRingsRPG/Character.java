package LordOfTheRingsRPG;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {
    private List<Item> inventory;

    public Character(List<Item> inventory) {
        this.inventory = inventory;
    }
}
