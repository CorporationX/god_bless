package school.faang.bjs2_33756;

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
