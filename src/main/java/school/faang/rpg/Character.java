package school.faang.rpg;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

}