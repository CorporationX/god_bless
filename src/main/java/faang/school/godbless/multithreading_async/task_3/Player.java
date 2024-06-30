package faang.school.godbless.multithreading_async.task_3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public class Player {
    private final String name;
    private final int level;
    private int experience;

    public synchronized Player startQuest(Quest quest) {
        try {
            Thread.sleep(quest.difficulty().getTimeCompletion());
        } catch (InterruptedException e) {
            log.error("Quest {} was interrupted for player {}", quest.name(), this.name, e);
        }
        this.experience += quest.reward();
        return this;
    }
}
