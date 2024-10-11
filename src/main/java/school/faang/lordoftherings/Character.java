package school.faang.lordoftherings;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private String name;
}
