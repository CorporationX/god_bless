package school.faang.bjs279250;

import school.faang.bjs279250.model.Archer;
import school.faang.bjs279250.model.Character;
import school.faang.bjs279250.model.Warrior;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello BJS2-79250!");
        Character warrior = new Warrior("Conan");
        Character archer = new Archer("Robin Hood");
        warrior.attack(archer);
        System.out.println(archer.getHealth());
        archer.attack(warrior);
        System.out.println(warrior.getHealth());
    }
}
