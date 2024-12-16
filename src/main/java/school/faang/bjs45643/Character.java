package school.faang.bjs45643;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
public class Character {
    private List<Item> inventory;
}
