package school.faang.bjs2_80356;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Character {
    private String name;
    public List<Item> inventory =  new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
