package school.faang.lord_of_rings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Character {
    private String name;
    private List<Item> inventory;
}
