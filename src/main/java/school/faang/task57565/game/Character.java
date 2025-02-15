package school.faang.task57565.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private final String name;
    private List<Item> inventory;
}
