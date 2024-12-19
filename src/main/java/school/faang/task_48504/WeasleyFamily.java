package school.faang.task_48504;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WeasleyFamily {
    private final List<Chore> chores = new ArrayList<>(List.of(new Chore("помыть посуду"),
            new Chore("покушать"), new Chore("пропылесосить"), new Chore("приготовить еду")));

}
