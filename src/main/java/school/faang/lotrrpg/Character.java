package school.faang.lotrrpg;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String characterName;
    private List<Item> inventory = new ArrayList<>();

    public Character(String characterName) {
        this.characterName = characterName;
    }
}
