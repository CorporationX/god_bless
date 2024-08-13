package lord_of_the_rings_rpg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@RequiredArgsConstructor
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}
