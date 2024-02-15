package faang.school.godbless.homm;

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
        while (!(firstHeroArmy.isEmpty()) && !(secondHeroArmy.isEmpty())) {
            Creature attacker = turn % 2 == 0 ? firstHeroArmy.get(firstHeroArmy.size() - 1) : secondHeroArmy.get(secondHeroArmy.size() - 1);
            Creature defender = turn % 2 == 0 ? secondHeroArmy.get(secondHeroArmy.size() - 1) : firstHeroArmy.get(firstHeroArmy.size() - 1);
            attack(attacker, defender);
            if (defender.getCount() == 0) {
                secondHero.removeCreature(defender);
                secondHeroArmy = secondHero.getArmy();
            } else {
                attack(defender, attacker);
                if (attacker.getCount() == 0) {
                    firstHero.removeCreature(defender);
                    firstHeroArmy = firstHero.getArmy();
                }
            }
            turn++;
        }
        return firstHeroArmy.isEmpty() ? secondHero : firstHero;
    }

    public void attack(Creature attacker, Creature defender) {
        if (attacker.getDamage() - defender.getDefancePoin() >= 0)
            defender.setCount(defender.getCount() - attacker.getDamage());
    }
}
