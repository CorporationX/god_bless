package school.faang.BJS233682;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();
}
