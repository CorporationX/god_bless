package school.faang.sprint3.task3;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
public class WeasleyFamily {
    private List<Chore> chores;

    public WeasleyFamily() {
        chores = new ArrayList<>();
    }

    public void startExecutingChores() {
        ExecutorService executor = Executors.newFixedThreadPool(chores.size());
        chores.forEach(executor::execute);
        executor.shutdown();
    }

    public void addChore(Chore chore) {
        chores.add(chore);
    }

}
