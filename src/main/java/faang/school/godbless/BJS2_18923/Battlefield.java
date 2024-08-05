package faang.school.godbless.BJS2_18923;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Battlefield {
    private Hero firstFighter;
    private Hero secondFighter;

    public Hero battle() {
        Hero attacker;
        Hero defender;
        int move = 0;
        while (!firstFighter.isDefeated() && !secondFighter.isDefeated()) {
            if (move % 2 == 0) {
                attacker = firstFighter;
                defender = secondFighter;
            } else {
                attacker = secondFighter;
                defender = firstFighter;
            }
            attack(attacker, defender);
            move++;
        }

        if (firstFighter.isDefeated()) {
            return secondFighter;
        } else {
            return firstFighter;
        }
    }

    public void attack(Hero attacker, Hero defender) {
        Random random = new Random();
        int attackerCreatureIdx = 0;
        if (attacker.getArmy().size() != 1) {
            attackerCreatureIdx = random.nextInt(0, attacker.getArmy().size() - 1);
        }
        int damage = attacker.getArmy().get(attackerCreatureIdx).getDamage();
        System.out.println("Герой " + attacker.getName() + " наносит урон " + damage + " существом " + attacker.getArmy().get(attackerCreatureIdx).getName());
        defence(defender, random, damage);
    }

    public void defence(Hero defender, Random random, int damage) {
        int defenderCreatureIdx = 0;
        if (defender.getArmy().size() != 1) {
            defenderCreatureIdx = random.nextInt(0, defender.getArmy().size() - 1);
        }
        Creature defenderCreature = defender.getArmy().get(defenderCreatureIdx);
        int absorbDamageCreature = defenderCreature.getQuantity() * defenderCreature.getDefense();
        System.out.println("Выдерживаемый урон " + absorbDamageCreature);
        System.out.println("Колво " + defenderCreature.getQuantity());
        int newQuantity = (absorbDamageCreature - damage) / defenderCreature.getDefense();
        if (newQuantity > 0) {
            defenderCreature.setQuantity(newQuantity);
            System.out.println("Кол -во " + defenderCreature.getQuantity());
        } else {
            defender.getArmy().remove(defenderCreature);
        }
        if (defender.getArmy().isEmpty()) {
            defender.setDefeated(true);
        }
    }
}
