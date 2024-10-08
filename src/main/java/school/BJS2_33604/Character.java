package school.BJS2_33604;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {

    private String name;
    private List<Item> items;

    public Character(String name) {
        this.name = name;
        items = new ArrayList<>();
    }
}
