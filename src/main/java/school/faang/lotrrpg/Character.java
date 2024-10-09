package school.faang.lotrrpg;

import lombok.Data;

@Data
public class Character {

    private String name;
    private Item[] inventory = new Item[5];
    private int money = 1000;

    public Character(String name) {
        this.name = name;
    }

}
