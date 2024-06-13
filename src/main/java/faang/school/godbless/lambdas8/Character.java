package faang.school.godbless.lambdas8;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private final String NAME;
    @Getter
    private final List<Item> inventory;

    public Character(String name) {
        this.NAME = name;
        this.inventory = new ArrayList<>();
    }
}
