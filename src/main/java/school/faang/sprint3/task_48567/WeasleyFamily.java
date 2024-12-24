package school.faang.sprint3.task_48567;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
@Getter
public class WeasleyFamily {
    public static final int COUNT_OF_CHORES = 8;
    private final List<Chore> chores = new LinkedList<>();

    public WeasleyFamily() {
        for (int i = 1; i <= COUNT_OF_CHORES; i++) {
            chores.add(new Chore("do something " + i));
        }
    }

}

