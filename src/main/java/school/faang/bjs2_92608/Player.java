package school.faang.bjs2_92608;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Player {
    private final String name;
    private final int level;
    private int experience;

    synchronized public void increaseExperience(int experience) {
        this.experience += experience;
    }

    void logPlayerCompletedQuest() {
        log.info("игрок {} прошел квест и имеет {} опыта", name, experience);
    }
}
