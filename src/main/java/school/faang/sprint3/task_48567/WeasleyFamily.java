package school.faang.sprint3.task_48567;

import lombok.Getter;

import java.util.List;

public class WeasleyFamily {
    @Getter
    private static final List<Chore> chores = List.of(
            new Chore("do something 1"),
            new Chore("do something 2"),
            new Chore("do something 3"),
            new Chore("do something 4"),
            new Chore("do something 5"),
            new Chore("do something 6"),
            new Chore("do something 7"),
            new Chore("do something 8")
    );
}

