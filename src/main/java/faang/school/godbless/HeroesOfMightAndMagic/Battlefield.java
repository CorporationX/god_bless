package faang.school.godbless.HeroesOfMightAndMagic;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Battlefield {

    private final Hero PLAYER_ONE, PLAYER_TWO;

    public void fight() {
        while (true) {
            PLAYER_ONE.attack(PLAYER_TWO);
            if (checkWin(PLAYER_ONE, PLAYER_TWO)) {
                break;
            }
            PLAYER_TWO.attack(PLAYER_ONE);
            if (checkWin(PLAYER_TWO, PLAYER_ONE)) {
                break;
            }
        }

    }

    private boolean checkWin(Hero attacker, Hero defender) {
        if (defender.getArmyHp() <= 0) {
            System.out.printf("%s одержал победу!\n", attacker.getName());
            return true;
        }
        return false;
    }
}