package school.faang.javacore.abstraction;

import lombok.Getter;

@Getter
public enum HeroesCharacteristics {
    CHARACTER_DEFAULT_STRENGTH(5),
    CHARACTER_DEFAULT_DEXTERITY(5),
    CHARACTER_DEFAULT_INTELLIGENCE(5),
    CHARACTER_DEFAULT_HEALTH(100),

    WARRIOR_DEFAULT_STRENGTH(10),
    WARRIOR_DEFAULT_DEXTERITY(5),
    WARRIOR_DEFAULT_INTELLIGENCE(3),

    ARCHER_DEFAULT_STRENGTH(3),
    ARCHER_DEFAULT_DEXTERITY(10),
    ARCHER_DEFAULT_INTELLIGENCE(5);

    private final int value;

    HeroesCharacteristics(int value) {
        this.value = value;
    }
}
