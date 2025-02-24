package school.faang.sprint4.task_63939;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Player {
    private final String name;
    private int level;
    @Setter
    private int experience;

    public Player joinQuest(Quest quest) {
        synchronized (this) {
            experience += quest.startQuest();
            return this;
        }
    }
}
