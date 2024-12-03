package school.faang.bjs243835;

import school.faang.bjs243835.characters.Archer;
import school.faang.bjs243835.characters.Character;
import school.faang.bjs243835.characters.Warrior;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("A");
        Character archer = new Archer("A");

        archer.attack(warrior);
        warrior.attack(archer);
        System.out.println("archer health = " + archer.getHealth());
        System.out.println("warrior health = " + warrior.getHealth());
    }
}
