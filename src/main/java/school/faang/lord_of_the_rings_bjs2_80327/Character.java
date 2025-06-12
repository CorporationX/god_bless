package school.faang.lord_of_the_rings_bjs2_80327;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Character {
    private String name;
    private List<Item> inventory;
}
