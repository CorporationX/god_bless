package school.faang.character;

import school.faang.character.model.Archer;
import school.faang.character.model.Warrior;

public class Main {
    public static void main(String[] args) {

        Warrior warriorCharacter = new Warrior("Воин Петя");
        Archer archerCharacter = new Archer("Лучница Валентина");

        for (int i = 0; i < 11; i++) {
            warriorCharacter.attack(archerCharacter);
        }
    }
}
