package school.faang;


import school.faang.bjs2_85588.Archer;
import school.faang.bjs2_85588.Character;
import school.faang.bjs2_85588.Warrior;

public class Main {

    public static void main(String[] args) {
        school.faang.bjs2_85588.Character testWar = new Warrior("Вар");
        school.faang.bjs2_85588.Character testArch = new Archer("Цыбуля");
        testBattle(testArch, testWar);
    }

    private static void testBattle(school.faang.bjs2_85588.Character opponentOne, Character opponentTwo) {
        while (opponentOne.getHealth() > 0 && opponentTwo.getHealth() > 0) {
            if (opponentTwo.isAlive(opponentTwo)) {
                opponentTwo.attack(opponentOne);
            }
            if (opponentOne.getHealth() > 0) {
                opponentOne.attack(opponentTwo);
            }
        }
    }
}
