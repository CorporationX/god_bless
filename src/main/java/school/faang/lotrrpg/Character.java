package school.faang.lotrrpg;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {

    private String name;
    private List<Item> items = new ArrayList<>();
    private int money = 1000;

    public Character(String name) {
        this.name = name;
    }

}
