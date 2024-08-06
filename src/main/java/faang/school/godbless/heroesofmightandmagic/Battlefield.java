package faang.school.godbless.heroesofmightandmagic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {

    private Hero attacker;
    private Hero defender;

    public void battle() {
        int moves = 0;
        while (!attacker.isDefeated() || !defender.isDefeated()) {
            if (moves % 2 == 0) {
                // attack(attacker, defender);
            } else {
                // attack(defender, attacker);
            }
            moves++;
        }
    }

    private void attack(Hero attacker, Hero defender) {
        // логика атаки
    }
}