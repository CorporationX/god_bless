package school.faang.bjs2_88455;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@ToString
public class Character {
    private final String name;
    private final ArrayList<Item> inventory = new ArrayList<>();
}
