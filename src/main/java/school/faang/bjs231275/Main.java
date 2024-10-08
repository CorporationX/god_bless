package school.faang.bjs231275;

import school.faang.bjs231275.dto.Archer;
import school.faang.bjs231275.dto.Character;
import school.faang.bjs231275.dto.Warrior;

public class Main {
    public static void main(String[] args) {
        Character character1 = new Warrior("Warrior");
        Character character2 = new Archer("Archer");
        System.out.println(character1);
        System.out.println(character2);
        character1.attack(character2);
        character2.attack(character1);
        System.out.println(character1);
        System.out.println(character2);
    }
}
