package school.faang.bjs2_74668;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;
    private Integer level;
    private Integer experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }
}
