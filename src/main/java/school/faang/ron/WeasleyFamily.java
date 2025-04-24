package school.faang.ron;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WeasleyFamily {

    private final List<Chore> chores = new ArrayList<>();

    public void addChore(Chore chore) {
        if (chore == null) {
            throw new IllegalArgumentException("Chroe is null");
        }
        chores.add(chore);
    }

}
