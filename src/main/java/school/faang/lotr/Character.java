package school.faang.lotr;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Character {
    private final String name;

    private final List<Item> inventory = new ArrayList<>();

    public Character(String name, List<Item> inventoryList) {
        this.name = name;
    }
}
