package school.faang.bjs2_80378;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory;
}
