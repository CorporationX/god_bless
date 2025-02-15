package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private List<Item> inventory;

    public Character() {
        inventory = new ArrayList<>();
    }
}
