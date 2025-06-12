package school.faang.bjs2_80405;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Character {
    private String name;
    private List<Item> inventory;
}
