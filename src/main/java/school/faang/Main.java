package school.faang;

import lombok.extern.java.Log;
import school.faang.bsj_43843.Archer;
import school.faang.bsj_43843.Character;
import school.faang.bsj_43843.Warrior;

import java.util.List;

@Log
public class Main {

    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior_1");
        Character archer = new Archer("Archer_1");
        List<Character> characters = List.of(warrior, archer);
        log.info("Состояния персонажей перед боем:\n" + characters);

        attackCharacters(characters.get(0), characters.get(1));
        attackCharacters(characters.get(1), characters.get(0));
    }

    private static void attackCharacters(Character forward, Character defender) {
        log.info("Атакует " + forward.getName());
        forward.attack(defender);
        log.info("Состояние персонажей после раунда:");
        log.info("Нападающий: " + forward);
        log.info("Защитник: " + defender);
    }
}
