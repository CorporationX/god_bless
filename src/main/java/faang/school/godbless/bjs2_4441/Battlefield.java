package faang.school.godbless.bjs2_4441;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Battlefield {

    private Hero hero1;
    private Hero hero2;

    public Hero battle() {
        List<Creature> army1 = hero1.getArmy();
        List<Creature> army2 = hero2.getArmy();

        // Count armor + health and damage for army 1
        int armorHealthArmy1 = 0;
        int damageArmy1 = 0;
        for (Creature creature : army1) {
            armorHealthArmy1 += creature.getArmor() + creature.getHealth();
            damageArmy1 += creature.getDamage();
        }
        // Count armor + health and damage for army 2
        int armorHealthArmy2 = 0;
        int damageArmy2 = 0;
        for (Creature creature : army2) {
            armorHealthArmy2 += creature.getArmor() + creature.getHealth();
            damageArmy2 += creature.getDamage();
        }

        while (armorHealthArmy1 > 0 && armorHealthArmy2 > 0) {
            armorHealthArmy1 -= damageArmy2;
            armorHealthArmy2 -= damageArmy1;
        }
        System.out.println("Health army 1 after battle: " + armorHealthArmy1);
        System.out.println("Health army 2 after battle: " + armorHealthArmy2);
        return armorHealthArmy1 > armorHealthArmy2 ? hero1 : hero2;
    }
}
