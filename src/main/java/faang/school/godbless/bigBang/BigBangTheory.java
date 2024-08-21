package faang.school.godbless.bigBang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Task> tasks = List.of(
                new Task("1", "1"),
                new Task("2", "2"),
                new Task("3", "3"),
                new Task("4", "4")
        );

        for (Task task : tasks) {
            service.submit(task);
        }

        service.shutdown();
    }
}
