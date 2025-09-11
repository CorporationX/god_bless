package school.faang.bjs2_87330;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    protected Character(String name) {
        this.name = name;
    }
}
