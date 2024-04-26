package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String name;
    private int level;
    private int experience;

    public void increasedExperience(int experience) {
        if (this.experience + experience > 100) {
            level++;
            this.experience = this.experience + experience - 100;
        }
    }
}
