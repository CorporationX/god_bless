package faang.school.godbless.BJS2_18923;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Battlefield {
    private Hero firstFighter;
    private Hero secondFighter;

    public Hero battle() {
        int move = 0;
        System.out.println("Начальные армии");
        printHeroArmy(firstFighter);
        printHeroArmy(secondFighter);
        System.out.println("++++++++++++++++++");

        while (firstFighter.isNotDefeated() && secondFighter.isNotDefeated()) {
            if (move % 2 == 0) {
                attack(firstFighter, secondFighter);
            } else {
                attack(secondFighter, firstFighter);
            }
            move++;
        }
        if (firstFighter.isNotDefeated()) {
            return secondFighter;
        } else {
            return firstFighter;
        }
    }

    public void attack(Hero attacker, Hero defender) {
        Random random = new Random();
        int attackerCreatureIdx = 0;
            attackerCreatureIdx = random.nextInt( attacker.getArmy().size());
        int damage = attacker.getArmy().get(attackerCreatureIdx).getDamage();
        System.out.println("Новый раунд");
        System.out.println("Герой " + attacker.getName() + " наносит урон " + damage
                + " существом " + attacker.getArmy().get(attackerCreatureIdx).getName());
        defence(defender, random, damage);
    }

    public void defence(Hero defender, Random random, int damage) {
        int defenderCreatureIdx = 0;
            defenderCreatureIdx = random.nextInt(0, defender.getArmy().size());
        Creature defenderCreature = defender.getArmy().get(defenderCreatureIdx);
        int absorbDamageCreature = defenderCreature.getQuantity() * defenderCreature.getDefense();
        int newQuantity = (absorbDamageCreature - damage) / defenderCreature.getDefense();
        defender.removeCreature(defenderCreature, newQuantity);
        printHeroArmy(defender);
        System.out.println("==========");
        if (defender.getArmy().isEmpty()) {
            defender.setNotDefeated(false);
        }
    }

    public void printHeroArmy(Hero hero) {
        System.out.println("Армия героя " + hero.getName() + ":");
        hero.getArmy().forEach(creature -> System.out.println(creature.getName() + " - " + creature.getQuantity() + " шт."));
    }
}
