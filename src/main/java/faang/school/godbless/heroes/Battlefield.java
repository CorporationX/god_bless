package faang.school.godbless.heroes;

import java.util.List;

public class Battlefield {

    private Hero firstHero;
    private Hero secondHero;
    private List<Creature> firstHeroArmy;
    private List<Creature> secondHeroArmy;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
        this.firstHeroArmy = firstHero.getArmy();
        this.secondHeroArmy = secondHero.getArmy();
    }

    public Hero battle() {
        int turn = 0;
        while (!firstHeroArmy.isEmpty() && !secondHeroArmy.isEmpty()) {
            Creature attacker = turn % 2 == 0 ? firstHeroArmy.get(firstHeroArmy.size() - 1)
                                              : secondHeroArmy.get(secondHeroArmy.size() - 1);
            Creature defender = turn % 2 == 0 ? secondHeroArmy.get(secondHeroArmy.size() - 1)
                                              : firstHeroArmy.get(firstHeroArmy.size() - 1);
            attack(attacker, defender);
            if (!isAlive(defender)) {
                if (turn % 2 == 0) {
                    secondHero.removeCreature(defender);
                    secondHeroArmy = secondHero.getArmy();
                }
                else {
                    firstHero.removeCreature(defender);
                    firstHeroArmy = firstHero.getArmy();
                }
            }
            turn++;
        }

        if (firstHeroArmy.isEmpty()) {
            return secondHero;
        }
        else {
            return firstHero;
        }
    }

    private void attack(Creature attacker, Creature defender) {
        int damage = attacker.getDamage() - defender.getDefence();
        if (damage <= 0) return;
        defender.setCount(defender.getCount() - damage);
    }

    private boolean isAlive(Creature creature) {
        return creature.getCount() > 0;
    }
}
