package BJS2_4952;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public Hero battle() {
        while (true) {
            try {
                attack(firstHero, secondHero);
                attack(secondHero, firstHero);
            } catch (IndexOutOfBoundsException ex) {
                return checkWinner(firstHero, secondHero);
            }
        }
    }

    private Hero checkWinner(Hero attacker, Hero defender) {
        if (attacker.getARMY().isEmpty()) {
            defender.giveExperience();
            return defender;
        }
        if (defender.getARMY().isEmpty()) {
            attacker.giveExperience();
            return attacker;
        }
        return null;
    }


    private void attack(Hero attacker, Hero defender) {
        defender.removeCreature(defender.getARMY().get(0), attacker.getARMY().get(0).getDamage());
    }
}
