package faang.school.godbless.lord_of_the_rings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }
}
