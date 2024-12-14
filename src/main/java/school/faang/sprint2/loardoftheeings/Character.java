package school.faang.sprint2.loardoftheeings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Character {
    String name;
   private final List<Item> inventory = new ArrayList<>();
}
