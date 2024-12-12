package school.faang.sprint2.bjs_45630;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    private List<Item> inventory = new ArrayList<>();
}
