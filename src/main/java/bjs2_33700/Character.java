package bjs2_33700;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private List<Item> inventory;

    public Character() {
        this.inventory = new ArrayList<>();
    }
}
