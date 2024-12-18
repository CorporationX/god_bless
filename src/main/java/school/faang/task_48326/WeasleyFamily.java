package school.faang.task_48326;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WeasleyFamily {
    private final List<Chore> chores = new ArrayList<>();

    public void addChore(@NonNull Chore chore) {
        chores.add(chore);
    }
}
