package school.faang.godbless.bjs2_38510;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class Player {
    private String name;
    private int level;
    private int experience;

    public synchronized void addExperience(int gain) {
        this.experience += gain;
        log.info("Player {} has new experience value {}", name, experience);
    }
}
