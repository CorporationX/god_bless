package lord_of_the_rings_rpg;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private List<Item> inventory;
}
