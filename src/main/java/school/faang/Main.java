package school.faang;

import school.faang.bsj_43843.Archer;
import school.faang.bsj_43843.Character;
import school.faang.bsj_43843.Warrior;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Character> characters = List.of(new Warrior("Warrior_1"), new Archer("Archer_1"));
        System.out.println("Состояния персонажей перед боем:");
        System.out.println(characters);

        attackCharacters(characters.get(0), characters.get(1));
        attackCharacters(characters.get(1), characters.get(0));
    }

    private static void attackCharacters(Character forward, Character defender) {
        System.out.println("Атакует " + forward.getName());
        forward.attack(defender);
        System.out.println("Состояние персонажей после раунда:");
        System.out.println("Нападающий: " + forward);
        System.out.println("Защитник: " + defender);
    }
}
