package faang.school.godbless.BJS2_21277;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    Character(String name) {
        this.name = name;
    }
}
