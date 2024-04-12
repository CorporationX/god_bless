package faang.school.godbless.lord;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class Character {
    private String name;
    private List<Item> inventories;

    public Character(String name) {
        this.name = name;
        this.inventories = new ArrayList<>();
    }
}
