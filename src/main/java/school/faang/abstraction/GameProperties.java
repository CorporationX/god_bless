package school.faang.abstraction;


import lombok.Getter;

@Getter
public final class GameProperties {
    static final int CHARACTER_DEFAULT_STRENGTH = 5;
    static final int CHARACTER_DEFAULT_DEXTERITY = 5;
    static final int CHARACTER_DEFAULT_INTELLECT = 5;
    static final int WARRIOR_DEFAULT_STRENGTH = 10;
    static final int WARRIOR_DEFAULT_DEXTERITY = 5;
    static final int WARRIOR_DEFAULT_INTELLECT = 3;
    static final int ARCHER_DEFAULT_STRENGTH = 3;
    static final int ARCHER_DEFAULT_DEXTERITY = 10;
    static final int ARCHER_DEFAULT_INTELLECT = 5;

    private GameProperties() {}

}
