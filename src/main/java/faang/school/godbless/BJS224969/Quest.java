package faang.school.godbless.BJS224969;

import lombok.Getter;

@Getter
public class Quest {
    private String name;
    private Integer difficulty;
    private Long reward;

    public Quest(String name, Integer difficulty, Long reward) {
        this.name = name;
        this.difficulty = difficulty;
        this.reward = reward;
    }
}
