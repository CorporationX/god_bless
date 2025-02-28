package school.faang.task62206.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;


    public void addExperience(int upExp) {
        if (upExp < 0) {
            throw new IllegalArgumentException("Опыт не может быть отрицательным.");
        }
        this.experience += upExp;
    }
}