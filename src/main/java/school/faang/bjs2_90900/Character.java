package school.faang.bjs2_90900;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();

    protected Character(String name) {
        this.name = name;
    }
}
