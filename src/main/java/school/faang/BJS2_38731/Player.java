package school.faang.BJS2_38731;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int exp) {
        this.experience += exp;
    }
}
