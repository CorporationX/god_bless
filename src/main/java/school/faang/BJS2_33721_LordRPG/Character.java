package school.faang.BJS2_33721_LordRPG;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Character {
    private String name;
    private Map<Item, Integer> inventory;

    public Character(String name) {
        ValidationUtils.validateString(name, "Invalid name!");
        inventory = new HashMap<>();
    }
}
