package faang.school.godbless.BJS2_18901;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public Hero battle() {
        int damageAttacker = attacker.calculeteTotalDamage();
        int damageDefender = defender.calculeteTotalDamage();
        System.out.println(attacker.getName() + " damage " + damageAttacker + " to " + defender.getName());
        System.out.println(defender.getName() + " damage " + damageDefender + " to " + attacker.getName());

        if (damageAttacker > damageDefender) {
            System.out.println(attacker.getName() + " - won");
            return attacker;
        } else if (damageDefender > damageAttacker) {
            System.out.println(defender.getName() + " - won");
            return defender;
        } else {
            System.out.println("tie!");
            return null;
        }
    }
}
