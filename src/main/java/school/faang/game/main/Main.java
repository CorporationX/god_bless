package school.faang.game.main;

import school.faang.game.characters.Archer;
import school.faang.game.characters.Warrior;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Richard the Lionheart");
        Archer archer = new Archer("Robin Hood");
        System.out.println("create new character - warrior: " + warrior);
        System.out.println("create new character - archer: " + archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("warrior health after attack:" + warrior.getHealth());
        System.out.println("archer health after attack:" + archer.getHealth());
    }
}