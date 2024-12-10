package school.faang.bjs245540;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}
