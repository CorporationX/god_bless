package school.faang.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory;
}