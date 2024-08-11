package faang.school.godbless.BJS2_18901;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public Hero battle() {
        int damageAttacker = attacker.calculeteTotalDamage();
        int damageDefender = defender.calculeteTotalDamage();
        System.out.println(attacker.getName() + " deals damage " + damageAttacker + " to " + defender.getName());
        System.out.println(defender.getName() + " deals damage " + damageDefender + " to " + attacker.getName());

        if (damageAttacker > damageDefender) {
            System.out.println(attacker.getName() + " - wins!");
            return attacker;
        } else if (damageDefender > damageAttacker) {
            System.out.println(defender.getName() + " - wins!");
            return defender;
        } else {
            System.out.println("tie!");
            return null;
        }
    }
}
