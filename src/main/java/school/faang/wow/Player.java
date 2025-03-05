package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int experience) {
        this.experience += experience;
    }

    public void getInfo() {
        log.info("{} has completed the quest and now has {} experience points.", this.getName(), this.getExperience());
    }
}
