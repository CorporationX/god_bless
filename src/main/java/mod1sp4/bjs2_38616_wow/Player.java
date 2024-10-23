package mod1sp4.bjs2_38616_wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public void addExperience(int amount) {
        experience += amount;
    }
}
