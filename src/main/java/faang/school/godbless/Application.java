package faang.school.godbless;

import faang.school.godbless.character.Archer;
import faang.school.godbless.character.Character;
import faang.school.godbless.character.Warrior;

public class Application {
    public static void main(String[] args) {

        Character warrior = new Warrior("Ben");
        Character archer = new Archer("Steve");

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(archer);
        System.out.println(warrior);


    }


}
