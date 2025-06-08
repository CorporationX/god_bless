package school.faang.bjs2_79245;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    public Archer(String name, int strength, int dexterity, int intellect) {
        super(name, strength, dexterity, intellect);
    }

    public void attack(Character opponent) throws Exception {
        if (this.isAlive()) {
            log.info(this.getName() + " attacks " + opponent.getName());
            int damage = opponent.getHealthPoints() - this.getDexterity();
            opponent.setHealthPoints(damage);
        } else {
            throw new RuntimeException(this.getName() + " is dead...");
        }
    }
}
