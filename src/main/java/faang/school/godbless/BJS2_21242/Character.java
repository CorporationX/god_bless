package faang.school.godbless.BJS2_21242;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Character {
    final List<Item> inventory;
    final String name;

    public Character(String name) {
        this.inventory = new ArrayList<>();
        this.name = name;
    }
}
