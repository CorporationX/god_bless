package school.faang.sprint2.bjs_45539;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
}
