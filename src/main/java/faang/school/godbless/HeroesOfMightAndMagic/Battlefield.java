package faang.school.godbless.HeroesOfMightAndMagic;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Battlefield {

    private final Hero playerOne, playerTwo;

    public void fight() {
        while (true) {
            playerOne.attack(playerTwo);
            if (checkWin(playerOne, playerTwo)) {
                break;
            }
            playerTwo.attack(playerOne);
            if (checkWin(playerTwo, playerOne)) {
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