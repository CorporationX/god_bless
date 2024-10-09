package school.faang.RPG;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private final String type;
    private final List<Item> inventory = new ArrayList<>();
}
