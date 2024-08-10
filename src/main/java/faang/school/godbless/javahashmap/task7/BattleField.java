package faang.school.godbless.javahashmap.task7;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class BattleField {
    private Hero firstHero;
    private Hero secondHero;
    private boolean orderOfMove = true;

    public BattleField(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Hero battle() {
        firstHero.setDefeated(false);
        secondHero.setDefeated(false);
        System.out.println("Начало боя");
        System.out.println();
        while (!firstHero.isDefeated() && !secondHero.isDefeated()) {
            if (orderOfMove) {
                System.out.println("Ход героя: " + firstHero.getName());
                attackCreature(firstHero, secondHero);
                orderOfMove = false;
            } else {
                System.out.println("Ход героя: " + secondHero.getName());
                attackCreature(secondHero, firstHero);
                orderOfMove = true;
            }
        }
        return firstHero.isDefeated() ? secondHero : firstHero;
    }

    private void attackCreature(Hero firstHero, Hero secondHero) {
        Random random = new Random();
        int indexCurrent;
        int damage;
        int fullHp;
        int currentHp;
        int currentQuantity;

        indexCurrent = random.nextInt(firstHero.getAliveCreature());
        Creature creatureFirstHero = firstHero.getCreatures().get(indexCurrent);
        indexCurrent = random.nextInt(secondHero.getAliveCreature());
        Creature creatureSecondHero = secondHero.getCreatures().get(indexCurrent);
        damage = (creatureFirstHero.getDamage() * (10 - creatureSecondHero.getDefence()) / 10);
        fullHp = (creatureSecondHero.getQuantity() - 1) * creatureSecondHero.getDefaultHp() +
                creatureSecondHero.getCurrentHp();
        if (damage >= fullHp) {
            secondHero.removeCreature(creatureSecondHero, creatureSecondHero.getQuantity());
        } else {
            currentHp = (fullHp - damage) % creatureSecondHero.getDefaultHp();
            currentQuantity = (fullHp - damage - currentHp) / creatureSecondHero.getDefaultHp();
            if (currentHp != 0) {
                currentQuantity++;
            } else {
                currentHp = 100;
            }
            secondHero.removeCreature(creatureSecondHero, currentQuantity);
            creatureSecondHero.setCurrentHp(currentHp);
            System.out.println(creatureFirstHero.getName() + " атаковало " + creatureSecondHero.getName() +
                    ". Нанесено " + damage + " урона, погибло " + currentQuantity);
        }
    }
}
