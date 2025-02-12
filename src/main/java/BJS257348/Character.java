package BJS257348;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Character {
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
