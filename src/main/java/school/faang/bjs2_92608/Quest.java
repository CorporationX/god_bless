package school.faang.bjs2_92608;

import lombok.Getter;

@Getter
public class Quest {
    private final String name;
    private final Difficult difficult;
    private final int reward;

    public Quest(String name, Difficult difficult, int reward) {
        this.name = name;
        this.difficult = difficult;
        this.reward = reward;
    }
}
