package lord.rings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Character {

    private String name;

    public Character(String name) {
        this.name = name;
    }

    List<Item> inventory = new ArrayList<>();
}
