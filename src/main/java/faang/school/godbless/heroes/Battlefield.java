package faang.school.godbless.heroes;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Battlefield {
    private final Hero hero1;
    private final Hero hero2;

    public Optional<Hero> battle() {
        while (!hero1.getArmy().isEmpty() && !hero2.getArmy().isEmpty()) {
            Creature hero1Creature = hero1.getRandomCreature();
            System.out.println("\n" + hero1.getName() + " выбрал игрока " + hero1Creature.getName());
            Creature hero2Creature = hero2.getRandomCreature();
            System.out.println(hero2.getName() + " выбрал игрока " + hero2Creature.getName());

            attack(hero1Creature, hero2Creature);

            if (hero2Creature.getQuantity() == 0) {
                System.out.println("Игрок " + hero2.getName() + ": " + hero2Creature.getName() + " погиб");
                hero2.removeCreature(hero2Creature);

                if (hero2.getArmy().isEmpty()) {
                    continue;
                }

                hero2Creature = hero2.getRandomCreature();
                System.out.println(hero2.getName() + " поменял игрока на " + hero2Creature.getName());
            }

            attack(hero2Creature, hero1Creature);

            if (hero1Creature.getQuantity() == 0) {
                System.out.println("Игрок " + hero1.getName() + ": " + hero1Creature.getName() + " погиб");
                hero1.removeCreature(hero1Creature);
            }
        }

        System.out.println("\nБой закончился, определяем победителя");
        System.out.println("Размер армии " + hero1.getName() + " — " + hero1.getArmy().size() + " игроков");
        System.out.println("Размер армии " + hero2.getName() + " — " + hero2.getArmy().size() + " игроков");

        if (hero1.getArmy().isEmpty() && hero2.getArmy().isEmpty()) {
            System.out.println("Ничья");
            return Optional.empty();
        }

        if (!hero1.getArmy().isEmpty()) {
            System.out.println("Победил " + hero1.getName());
            return Optional.of(hero1);
        }

        System.out.println("Победил " + hero2.getName());
        return Optional.of(hero2);
    }

    private void attack(Creature attackerCreature, Creature defenderCreature) {
        System.out.println("\n" + attackerCreature.getName() + " атакует " + defenderCreature.getName());
        System.out.println(attackerCreature);
        System.out.println(defenderCreature);

        int defenderCreatureResultHealth = Math.max(defenderCreature.getHealth() - attackerCreature.getDamage(), 0);
        double defenderCreatureResultQuantity = Math.ceil((double) defenderCreatureResultHealth / defenderCreature.getDefence());

        defenderCreature.setQuantity((int) defenderCreatureResultQuantity);

        System.out.println("Количество " + defenderCreature.getName() + " после удара — " + defenderCreature.getQuantity());
    }
}
