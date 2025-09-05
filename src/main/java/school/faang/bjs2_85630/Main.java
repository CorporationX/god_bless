package school.faang.bjs2_85630;

import school.faang.bjs2_85630.character.Character;
import school.faang.bjs2_85630.character.Warrior;
import school.faang.bjs2_85630.character.Archer;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("DIO", 20, 20, 10);
        Character archer = new Archer("Kakyoin", 5, 5, 4);

        System.out.println("Before the battle:");
        System.out.println(warrior);
        System.out.println(archer);
        System.out.println();

        System.out.println("The battle:");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println();

        System.out.println("After the battle");
        System.out.println(warrior);
        System.out.println(archer);
    }
}
