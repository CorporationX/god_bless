package lord.rings;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Character {

    @Setter
    private String name;

    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

}
