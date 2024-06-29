package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Data
public class Player {
    //Создайте класс Player с полями name, level, и experience.
    private String name;
    private int level;
    private int experience;

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }
}
