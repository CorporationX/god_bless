package school.faang.heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Warrior {
    private int id;
    private String name;
    private int power;
}
