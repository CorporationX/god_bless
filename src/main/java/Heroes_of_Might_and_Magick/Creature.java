package Heroes_of_Might_and_Magick;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int amount;

    public abstract int getDamage(Creature creature);
}
