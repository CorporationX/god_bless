package school.faang.multithreading.parallelism.very.nice.but.extremely.poor;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class WeasleyFamily {
    private List<Chore> chores = new ArrayList<>();

    public void addChore(String chore) {
        chores.add(new Chore(chore));
    }
}
