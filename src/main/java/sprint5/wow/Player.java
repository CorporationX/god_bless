package sprint5.wow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private final String name;
    private int level;
    private int experience;

    public void gainExperience(int experience) {
        this.experience += experience;
    }
}
