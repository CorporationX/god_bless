package school.faang.abstraction_abstraction;

import lombok.AllArgsConstructor;

public class CharacterConfig {
    @AllArgsConstructor
    public enum Turn {
        PLAYER_TURN,
        OPPONENT_TURN
    }

    public static final int BASE_STAT = 5;

    public static final int ARCHER_STRENGTH = 3;
    public static final int ARCHER_AGILITY = 10;
    public static final int ARCHER_INTELLIGENCE = 5;

    public static final int WARRIOR_STRENGTH = 10;
    public static final int WARRIOR_AGILITY = 5;
    public static final int WARRIOR_INTELLIGENCE = 3;
}
