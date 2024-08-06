package faang.school.godbless.Task18288.Battle;

import faang.school.godbless.Task18288.Creature;
import faang.school.godbless.Task18288.Hero;
import lombok.Data;

@Data
public class BattleField {

    private Hero hero1;
    private Hero hero2;

    public BattleField(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int winner1 = calculatePower(hero1);
        int winner2 = calculatePower(hero2);

        return winner1 > winner2 ? hero1 : hero2;

    }

    private int calculatePower(Hero hero) {
        int totalPower = 0;
        for (Creature creature : hero.getArmy()) {
            totalPower += creature.getDamage() * creature.getQuantity();
        }
        return totalPower;
    }
}
