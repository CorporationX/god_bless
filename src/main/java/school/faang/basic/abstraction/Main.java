package school.faang.basic.abstraction;

import lombok.extern.slf4j.Slf4j;
import school.faang.basic.abstraction.characters.Character;
import school.faang.basic.abstraction.characters.classes.Archer;
import school.faang.basic.abstraction.characters.classes.Mage;
import school.faang.basic.abstraction.characters.classes.Trainee;
import school.faang.basic.abstraction.characters.classes.Warrior;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<Character> heroes = List.of(
                new Warrior("Aragorn"),
                new Archer("Legolas"),
                new Mage("Gendalf")
        );
        List<Character> enemies = List.of(
                new Warrior("Ugly ork"),
                new Warrior("Mighty ork"),
                new Archer("Grumpy ork"),
                new Archer("Filthy ork-archer"),
                new Mage("Snicky ork-shaman"),
                new Trainee("Ork-intern")
        );

        Battler
                .battle(heroes, enemies)
                .forEach(Character::praise);
    }
}