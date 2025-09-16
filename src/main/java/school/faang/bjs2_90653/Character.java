package school.faang.bjs2_90653;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {
    private String name;
    private List<String> inventory;

    public Character(String name) {
        this.name = name;
    }

//    public Character(String name, List<String> inventory) {
//        this.name = name;
//        this.inventory = inventory ;
//     }
}