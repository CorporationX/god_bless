package school.faang.bjs270013;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Character {
    private final String name;
    private List<Item> items;
}