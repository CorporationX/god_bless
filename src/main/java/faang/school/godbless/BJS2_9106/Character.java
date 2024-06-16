package faang.school.godbless.BJS2_9106;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private String name;

    public Character(String name) {
        this.name = name;
    }
}
