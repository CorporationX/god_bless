package BJS262156;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void setExperience(int experience) {
        this.experience = experience;
    }
}
