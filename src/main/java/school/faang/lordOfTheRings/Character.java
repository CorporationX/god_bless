package school.faang.lordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private String name;
}
