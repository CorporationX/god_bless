package school.faang;

import school.faang.bsj2_56333.Archer;
import school.faang.bsj2_56333.Character;
import school.faang.bsj2_56333.Warrior;

public class RPGGame {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}