package school.faang.basic.abstraction;

import school.faang.basic.abstraction.characters.Character;

import java.util.List;

public record Fighter(Character character, List<Character> army) {
}
