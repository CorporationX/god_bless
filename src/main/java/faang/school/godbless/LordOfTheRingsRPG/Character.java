package faang.school.godbless.LordOfTheRingsRPG;

import java.util.ArrayList;
import java.util.List;

public record Character(List<Item> inventory) {
    public Character(List<Item> inventory) {
        this.inventory = new ArrayList<>(inventory);
    }

}
