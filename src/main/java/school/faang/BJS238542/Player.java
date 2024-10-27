package school.faang.BJS238542;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void updateExperience(int experience) {
        this.experience += experience;
    }
}
