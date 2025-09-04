package school.faang.bjs2_85588;


public class Main {

    public static void main(String[] args) {
        Character testWar = new Warrior("Я вар");
        Character testArch = new Archer("Цыбуля");
        while (!(testWar.getHealth() <= 0 || testArch.getHealth() <= 0)) {
            testWar.attack(testArch);
            testArch.attack(testWar);
        }
    }
}
