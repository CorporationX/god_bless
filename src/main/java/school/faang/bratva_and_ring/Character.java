package school.faang.bratva_and_ring;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this(name, new ArrayList<>());
    }
}
