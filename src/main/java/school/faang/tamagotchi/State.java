package school.faang.tamagotchi;

import lombok.Getter;

@Getter
public enum State {
    HUNGRY("голоден"),
    FULL("сыт"),
    BORED("скучает"),
    HAPPY("весел"),
    DIRTY("грязный"),
    CLEAN("чистый"),
    TIRED("устал"),
    SLEEP("спит");

    private final String description;

    State(String description) {
        this.description = description;
    }
}
