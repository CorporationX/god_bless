package school.faang.BJS2_32875;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Army {
    private String name;
    private int level;
    private int damage;
    private int protection;
    private int hp;

    public int strikeEnemy(Army army) {
        return army.getProtection() * army.getLevel() - this.damage * this.level;
    }
}