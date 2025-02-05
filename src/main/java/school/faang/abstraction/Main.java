package school.faang.abstraction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FORMAT_CLASS = "Class: %s, ";
    private static final String FORMAT_NAME = "name: %s, ";
    private static final String FORMAT_HEALTH = "health: %s, ";
    private static final String FORMAT_STRENGTH = "strength: %s, ";
    private static final String FORMAT_AGILITY = "agility: %s, ";
    private static final String FORMAT_INTELLIGENCE = "intelligence: %s\n";

    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();

        characters.add(new Warrior("Oleg"));
        characters.add(new Archer("Alexey"));

        printCharacters(characters);
        fightOneVsOne(characters.get(0), characters.get(1));
        printCharacters(characters);
        for (int iteration = 0; iteration < 10; iteration++) {
            fightOneVsOne(characters.get(0), characters.get(1));
        }
        printCharacters(characters);
    }

    private static void printCharacters(List<Character> characters) {
        characters.forEach(character -> {
            System.out.printf(FORMAT_CLASS, character.getClass().getSimpleName());
            System.out.printf(FORMAT_NAME, character.getName());
            System.out.printf(FORMAT_HEALTH, character.getHealth());
            System.out.printf(FORMAT_STRENGTH, character.getStrength());
            System.out.printf(FORMAT_AGILITY, character.getAgility());
            System.out.printf(FORMAT_INTELLIGENCE, character.getIntelligence());
        });
        System.out.println();
    }

    private static void fightOneVsOne(Character firstCharacter, Character secondCharacter) {
        firstCharacter.attack(secondCharacter);
        secondCharacter.attack(firstCharacter);
    }
}
