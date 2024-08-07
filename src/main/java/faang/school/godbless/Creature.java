package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int armour;
    @EqualsAndHashCode.Exclude
    private int count;
    @EqualsAndHashCode.Exclude
    private int health;

    public abstract int getDamage();
}
