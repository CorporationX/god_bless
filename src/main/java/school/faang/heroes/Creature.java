package school.faang.heroes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;

    public int damage() {
        return attack;
    }
}
