package school.faang;


import school.faang.bjs2_85588.Archer;
import school.faang.bjs2_85588.Warrior;

public class Main {

    public static void main(String[] args) {
        Warrior testWar = new Warrior("Вар");
        Archer testArch = new Archer("Цыбуля");

        while (testWar.getHealth() > 0 && testArch.getHealth() > 0) {
            if (testWar.isAlive()) {
                testWar.attack(testArch);
            }
            if (testArch.isAlive()) {
                testArch.attack(testWar);
                testWar.isAlive();
            }
        }
    }
}
