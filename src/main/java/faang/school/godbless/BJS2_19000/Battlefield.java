package faang.school.godbless.BJS2_19000;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int hero1TotalDamage = calculateTotalDamage(hero1);
        int hero2TotalDamage = calculateTotalDamage(hero2);

        applyDamage(hero1, hero2TotalDamage);
        applyDamage(hero2, hero1TotalDamage);

        int hero1RemainingUnits = countRemainingUnits(hero1);
        int hero2RemainingUnits = countRemainingUnits(hero2);

        if (hero1RemainingUnits > hero2RemainingUnits) {
            hero2.getArmy().clear();
            return hero1;
        } else if (hero2RemainingUnits > hero1RemainingUnits) {
            hero1.getArmy().clear();
            return hero2;
        } else {
            return null;
        }
    }

    private int calculateTotalDamage(Hero hero) {
        int totalDamage = 0;
        for (Creature creature : hero.getArmy().keySet()) {
            totalDamage += creature.getDamage();
        }
        return totalDamage;
    }

    private void applyDamage(Hero hero, int totalDamage) {
        List<Creature> toRemove = new ArrayList<>();
        Map<Creature, Integer> toUpdate = new HashMap<>();

        for (Creature creature : hero.getArmy().keySet()) {
            int creatureDefense = creature.getDefense() * creature.getQuantity();
            int remainingDamage = totalDamage - creatureDefense;
            int lostUnits = Math.max(0, remainingDamage / creature.getDefense());
            if (lostUnits >= creature.getQuantity()) {
                toRemove.add(creature);
            } else {
                toUpdate.put(creature, lostUnits);
            }
            totalDamage = Math.max(0, remainingDamage);
            if (totalDamage == 0) {
                break;
            }
        }
        for (Creature creature : toRemove) {
            hero.removeCreature(creature, creature.getQuantity());
        }
        for (Map.Entry<Creature, Integer> entry : toUpdate.entrySet()) {
            hero.removeCreature(entry.getKey(), entry.getValue());
        }
    }

    private int countRemainingUnits(Hero hero) {
        int totalUnits = 0;
        for (Creature creature : hero.getArmy().keySet()) {
            totalUnits += creature.getQuantity();
        }
        return totalUnits;
    }

    public static void main(String[] args) {
        Hero hero1 = new Hero("Артур", "Замок");
        Hero hero2 = new Hero("Ланцелот", "Оплот");

        hero1.addCreature(new Pikeman(50), 50);
        hero1.addCreature(new Griffin(30), 30);
        hero1.addCreature(new Swordman(20), 20);


        hero2.addCreature(new Pikeman(60), 60);
        hero2.addCreature(new Griffin(25), 25);
        hero2.addCreature(new Angel(10), 10);

        System.out.println("До битвы:");
        System.out.println(hero1);
        System.out.println(hero2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        battlefield.battle();

        System.out.println("После битвы:");
        System.out.println(hero1);
        System.out.println(hero2);
    }
}
