package faang.school.godbless.heroes;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Battlefield {
    private final Hero hero1;
    private final Hero hero2;

    /*
    * Алгоритм боя:
    * 1. Герои выбирают по рандомному игроку из армии
    * 2. Рандомный игрок 1 атакует рандомного игрока 2
    * 3. Если игрок 2 погибает, то герой удаляет его из армии и меняет на другого рандомного игрока
    * 4. Игрок 2 атакует игрока 1
    * 5. Если игрок 1 погибает, то герой удаляет его из армии
    * 6. Эта заруба продолжается, пока хотя бы у одного из героев есть армия
    * 7. Выбирается победивший герой. Может быть ничья
    * */
    public Optional<Hero> battle() {
        while (!hero1.getArmy().isEmpty() && !hero2.getArmy().isEmpty()) {
            startBattleBetweenTwoHeroes();
        }

        System.out.println("\nБой закончился, определяем победителя");
        System.out.println("Размер армии " + hero1.getName() + " — " + hero1.getArmy().size() + " игроков");
        System.out.println("Размер армии " + hero2.getName() + " — " + hero2.getArmy().size() + " игроков");

        return getWinner();
    }

    private void startBattleBetweenTwoHeroes() {
        Creature hero1Creature = hero1.getRandomCreature();
        System.out.println("\n" + hero1.getName() + " выбрал игрока " + hero1Creature.getName());
        Creature hero2Creature = hero2.getRandomCreature();
        System.out.println(hero2.getName() + " выбрал игрока " + hero2Creature.getName());

        attack(hero1Creature, hero2Creature);

        if (hero2Creature.getQuantity() == 0) {
            System.out.println("Игрок " + hero2.getName() + ": " + hero2Creature.getName() + " погиб");
            hero2.removeCreature(hero2Creature);

            if (hero2.getArmy().isEmpty()) {
                return;
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

    private void attack(Creature attackerCreature, Creature defenderCreature) {
        System.out.println("\n" + attackerCreature.getName() + " атакует " + defenderCreature.getName());
        System.out.println(attackerCreature);
        System.out.println(defenderCreature);

        int defenderCreatureResultHealth = Math.max(defenderCreature.getHealth() - attackerCreature.getDamage(), 0);
        double defenderCreatureResultQuantity = Math.ceil((double) defenderCreatureResultHealth / defenderCreature.getDefence());

        defenderCreature.setQuantity((int) defenderCreatureResultQuantity);

        System.out.println("Количество " + defenderCreature.getName() + " после удара — " + defenderCreature.getQuantity());
    }

    public Optional<Hero> getWinner() {
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
}
