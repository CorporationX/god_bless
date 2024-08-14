package faang.school.godbless.bjs219140;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.Random;

@Data
@AllArgsConstructor
public class Battlefield {
    public Hero attacker;
    public Hero defender;

    public void battle() {
        int attackerDamage = 0;
        int defenderDamage = 0;
        int count = 10;
        System.out.println(attacker.getName() + ": " + attacker.getArmy());
        System.out.println(defender.getName() + ": " + defender.getArmy());
        while (count >= 0) {

            Random random = new Random();
            int size = attacker.getArmy().size();
            int randomCreature = random.nextInt(size);
            Map.Entry<Creature, Integer> attackingCreature = attacker.getArmy()
                    .entrySet()
                    .stream()
                    .skip(randomCreature)
                    .findFirst()
                    .orElse(null);
            Map.Entry<Creature, Integer> defendingCreature = defender.getArmy()
                    .entrySet()
                    .stream()
                    .skip(randomCreature)
                    .findFirst()
                    .orElse(null);

            attackerDamage += attackingCreature.getValue() * attackingCreature.getKey().getDamage();
            defenderDamage += defendingCreature.getValue() * defendingCreature.getKey().getDamage();

            System.out.print(attacker.getName() + "'s " + attackingCreature.getKey().getName()  + " attacks ");
            System.out.println(defender.getName() + "'s " + defendingCreature.getKey().getName());
            System.out.println(attacker.getName() + "'s total damage: " + attackerDamage);
            System.out.print(defender.getName() + "'s " + defendingCreature.getKey().getName()  + " attacks ");
            System.out.println(attacker.getName() + "'s " + attackingCreature.getKey().getName());
            System.out.println(defender.getName() + "'s total damage: " + defenderDamage);
            count--;
        }

        if(attackerDamage > defenderDamage) {
            System.out.println(attacker.getName() + " wins");
        } else {
            System.out.println(defender.getName() + " wins");
        }
    }
}
