package faang.school.godbless.BJS224969;

import lombok.Getter;

@Getter
public class Player {
    private String name;
    private Integer level;
    private Long experience;

    public Player(String name, Integer level, Long experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addExperience(Long reward) {
        this.experience += reward;
    }
}
