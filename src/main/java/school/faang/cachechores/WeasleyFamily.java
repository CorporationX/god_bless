package school.faang.cachechores;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WeasleyFamily {
    private List<Chore> chores = new ArrayList<>();

    public void addChore(Chore chore) {
        chores.add(chore);
    }
}
