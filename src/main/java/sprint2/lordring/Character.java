package sprint2.lordring;

import lombok.Getter;
import lombok.Setter;

import javax.management.ConstructorParameters;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    String characterName;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        characterName = name;
    }

}
