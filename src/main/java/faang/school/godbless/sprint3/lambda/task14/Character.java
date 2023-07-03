package faang.school.godbless.sprint3.lambda.task14;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private String name;

    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new ArrayList<>();
    }
}
