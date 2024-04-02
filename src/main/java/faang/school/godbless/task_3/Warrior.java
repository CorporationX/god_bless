package faang.school.godbless.task_3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        setStrength(10);
        setDexterity(5);
        setIntelligence(3);
    }

    @Override
    public void attack(Character opponent) {
        opponent.setHealth(opponent.getHealth() - this.getStrength());
    }
}
