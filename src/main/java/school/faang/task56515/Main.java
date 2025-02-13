package school.faang.task56515;

import school.faang.task56515.character.Archer;
import school.faang.task56515.character.Character;
import school.faang.task56515.character.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior attakerWarrior = new Warrior("Aragorn");
        Archer attakerArcher = new Archer("Legolas");
        Character defender = new Warrior("Ork");
        attakerWarrior.attack(defender);
        attakerArcher.attack(defender);
        System.out.println(defender.getHealth());
    }
}
