package school.faang.bjs2_85588;


public class Main {

    public static void main(String[] args) {
        Character testWar = new Warrior("Вар");
        Character testArch = new Archer("Цыбуля");
        testBattle(testArch, testWar);
    }

    private static void testBattle(Character opponentOne, Character opponentTwo) {
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
