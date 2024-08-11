package faang.school.godbless.BJS2_19094;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero whiteSide;
    private Hero blackSide;

    public String battle() {
        int armyWhiteDamage = calculateTotalDamage(whiteSide);
        int armyBlackDamage = calculateTotalDamage(blackSide);

        if (armyWhiteDamage > armyBlackDamage) {
            return whiteSide + " Побеждает";
        } else if (armyBlackDamage > armyWhiteDamage) {
            return blackSide + " Побеждает";
        } else {
            return "Ничья";
        }
    }

    private int calculateTotalDamage(Hero hero) {
        int totalDamage = 0;
        for (Army unit : hero.getArmy().values()) {
            totalDamage += unit.getCreature().getDamage() * unit.getQuantity();
        }
        return totalDamage;
    }
}
