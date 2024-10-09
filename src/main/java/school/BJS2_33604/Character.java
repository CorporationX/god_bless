package school.BJS2_33604;

import lombok.Getter;
import lombok.Setter;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class Character {

    private String name;
    private List<Item> items;

    public Character(String name) {
        this.name = name;
        items = new LinkedList<>();
    }
}
