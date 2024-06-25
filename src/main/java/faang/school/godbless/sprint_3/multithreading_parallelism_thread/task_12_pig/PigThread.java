package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_12_pig;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PigThread extends Thread{
    protected String pigName;
    protected int material;

    @Override
    public void run() {
        super.run();
    }
}
