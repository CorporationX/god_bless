package school.faang.bjs2_91247.character_groups;

import lombok.Getter;
import school.faang.bjs2_91247.character.Character;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Squad {
    private final List<school.faang.bjs2_91247.character.Character> characters;

    public Squad(CharacterClass characterClass, school.faang.bjs2_91247.character.Character... someCharacters) {
        for (school.faang.bjs2_91247.character.Character character : someCharacters) {
            if (!character.getClass().getSimpleName().equals(characterClass.getCharacterClassName())) {
                throw new IllegalArgumentException(String.format("В одном отряде " +
                        "могут быть персонажи исключительно определенного типа. " +
                        "В данном случае: %s", characterClass.getCharacterClassName()));
            }
        }
        characters = new ArrayList<>(Arrays.stream(someCharacters).toList());
    }

    public List<school.faang.bjs2_91247.character.Character> getCharacterSquad() {
        return new ArrayList<>(characters);
    }

    public int calculateSquadPower() {
        return characters.stream()
                .mapToInt(Character::getPower)
                .sum();
    }

    @Getter
    public enum CharacterClass {
        ARCHERS("Archer"),
        MAGICIANS("Magician"),
        SWORDSMEN("Swordsman");

        private final String characterClassName;

        CharacterClass(String characterClassName) {
            this.characterClassName = characterClassName;
        }
    }
}