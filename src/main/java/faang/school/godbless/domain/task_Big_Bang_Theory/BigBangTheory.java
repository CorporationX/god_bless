package faang.school.godbless.domain.task_Big_Bang_Theory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Task> taskList = new ArrayList<>();

        taskList.add(new Task("мусор", "собрать мусор"));
        taskList.add(new Task("уборка", "убрать картиру"));
        taskList.add(new Task("полы", "помыть полы"));
        taskList.add(new Task("стирка", "постирать вещи"));

        taskList.forEach(executor::submit);
        executor.shutdown();


    }
}
