package school.faang.nice_but_poor;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WeasleyFamily {
    private final List<String> chores = new ArrayList<>(List.of("помыть посуду", "подмести пол", "приготовить ужин"));
}
