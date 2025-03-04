package school.faang.task62302;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private final Object experienceLock = new Object();
    private String name;
    private int level;
    private int experience;

    public int getExperience() {
        synchronized (experienceLock) {
            return experience;
        }
    }

    public void setExperience(int experience) {
        synchronized (experienceLock) {
            this.experience = experience;
        }
    }
}
