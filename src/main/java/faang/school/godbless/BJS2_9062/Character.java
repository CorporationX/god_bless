package faang.school.godbless.BJS2_9062;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@AllArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }
}
