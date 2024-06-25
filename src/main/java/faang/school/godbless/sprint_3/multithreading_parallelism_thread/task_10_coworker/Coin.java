package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_10_coworker;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Coin {
    private int cost = 1;

    public void incCost() {
        cost+= 1;
    }
}
