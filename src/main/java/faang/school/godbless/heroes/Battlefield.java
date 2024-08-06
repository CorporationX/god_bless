package faang.school.godbless.heroes;

public class Battlefield {
    private Hero whiteHero;
    private Hero blackHero;

    public Battlefield(Hero whiteHero, Hero blackHero) {
        this.whiteHero = whiteHero;
        this.blackHero = blackHero;
    }

    public Hero battle() {
        int counter = 0;
        while (!(whiteHero.isDied() | blackHero.isDied())) {
            if (counter % 2 == 0) {
                attack(whiteHero, blackHero);
            } else {
                attack(blackHero, whiteHero);
            }
            counter++;
        }

        Hero winner;
        if (whiteHero.getArmy().isEmpty()) {
            winner = blackHero;
        } else {
            winner = whiteHero;
        }

        return winner;
    }

    private void attack(Hero attacker, Hero defender) {
        Creature attackerCreature = attacker.getArmy().iterator().next();
        Creature defenderCreature = defender.getArmy().iterator().next();

        defender.removeCreature(defenderCreature, attackerCreature.getQuantity());
    }
}
