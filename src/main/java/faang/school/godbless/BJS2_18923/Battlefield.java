package faang.school.godbless.BJS2_18923;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.stream.IntStream;

@AllArgsConstructor
public class Battlefield {
    private Hero firstFighter;
    private Hero secondFighter;


    public Hero battle() {
        Random random = new Random();
        Hero attacker;
        Hero defender;
        while (!firstFighter.isDefeated() || !secondFighter.isDefeated()) {
            int whichMove = random.nextInt(1, 3);
            if (whichMove == 1) {
                attacker = firstFighter;
                defender = secondFighter;
            } else {
                attacker = secondFighter;
                defender = firstFighter;
            }
            attack(attacker, defender);
//            break;
        }


        return null;
    }

    public void attack(Hero attacker, Hero defender) {
        Random random = new Random();
        int attackerCreatureIdx = 0;
        if (attacker.getArmy().size()>0) {
            attackerCreatureIdx = random.nextInt(0, attacker.getArmy().size() - 1);
        }
        int damage = attacker.getArmy().get(attackerCreatureIdx).getDamage();
        System.out.println("Герой "+attacker.getName()+" наносит урон "+damage+" существом "+attacker.getArmy().get(attackerCreatureIdx).getName());
        int defenderCreatureIdx = 0;
        if (defender.getArmy().size()>0) {
            defenderCreatureIdx = random.nextInt(0, defender.getArmy().size() - 1);
        }
        Creature defenderCreature = defender.getArmy().get(defenderCreatureIdx);
        int absorbDamageCreature = defenderCreature.getQuantity() * defenderCreature.getDefense();
        System.out.println("Выдерживаемый урон "+absorbDamageCreature);
        System.out.println("Колво "+defenderCreature.getQuantity());
        int newQuantity = (absorbDamageCreature - damage) / defenderCreature.getDefense();
        if (newQuantity > 0) {
            defenderCreature.setQuantity(newQuantity);
            System.out.println("Кол -во "+defenderCreature.getQuantity());
        } else {
            defender.getArmy().remove(defenderCreature);
        }

        if (heroAbsorbDamage(attacker) <= 0) {
            attacker.setDefeated(true);
        } else if (heroAbsorbDamage(defender) <= 0) {
            defender.setDefeated(true);
        }
    }

    public int heroAbsorbDamage(Hero hero) {
        return hero.getArmy().stream()
                .flatMapToInt(creature -> IntStream.of(creature.getQuantity() * creature.getDefense()))
                .sum();
    }
}
