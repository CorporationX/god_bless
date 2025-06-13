package school.faang.BJS2_79250;

import school.faang.BJS2_79250.model.Archer;
import school.faang.BJS2_79250.model.Character;
import school.faang.BJS2_79250.model.Warrior;

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
