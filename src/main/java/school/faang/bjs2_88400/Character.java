package school.faang.bjs2_88400;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private String name;
    @Setter private List<Item> inventory;
}
