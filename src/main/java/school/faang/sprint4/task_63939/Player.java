package school.faang.sprint4.task_63939;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Getter
@ToString
public class Player {
    @Setter
    private final AtomicInteger experience = new AtomicInteger();
    private final String name;
    private int level;

    public Player joinQuest(Quest quest) {
        experience.addAndGet(quest.startQuest());
        return this;
    }
}
