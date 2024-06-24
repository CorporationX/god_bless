package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_6_royal_harbor;

import java.util.ArrayList;
import java.util.List;

public record Tournament(List<Knight> knights) {
    public Tournament() {
        this(new ArrayList<>());
    }

    public void addKnight(Knight knight) {
        knights.add(knight);
    }
}
