package school.faang.rpg;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Character {
    private List<Item> inventory = new ArrayList<>();
}
