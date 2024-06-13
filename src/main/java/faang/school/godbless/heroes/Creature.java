package faang.school.godbless.heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Creature {
    private final String name;
    private final int damage;
    private final int defence;
    private int quantity;

    public int getHealth() {
        return defence * quantity;
    }

    public int getDamage() {
        return damage * quantity;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", defence=" + defence +
                ", quantity=" + quantity +
                ", totalHealth=" + getHealth() +
                ", totalDamage=" + getDamage() +
                '}';
    }
}
