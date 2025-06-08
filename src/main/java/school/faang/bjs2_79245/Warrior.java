package school.faang.bjs2_79245;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 11, 5, 3);
    }

    public Warrior(String name, int strength, int dexterity, int intellect) {
        super(name, strength, dexterity, intellect);
    }

    @Override
    public void attack(Character opponent) throws Exception {
        if (this.isAlive()) {
            log.info(this.getName() + " attacks " + opponent.getName());
            int damage = opponent.getHealthPoints() - this.getStrength();
            opponent.setHealthPoints(damage);
        } else {
            throw new RuntimeException(this.getName() + " is dead...");
        }
    }
}
