package school.faang.sprint.first.character;

import school.faang.sprint.first.character.model.Archer;
import school.faang.sprint.first.character.model.Warrior;

public class Main {
    public static void main(String[] args) {

        Warrior warriorCharacter = new Warrior("Воин Петя");
        Archer archerCharacter = new Archer("Лучница Валентина");

        for (int i = 0; i < 11; i++) {
            warriorCharacter.attack(archerCharacter);
        }
    }
}
