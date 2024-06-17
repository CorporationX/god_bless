package faang.school.godbless.TheBigBangTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Kirill", "читать"));
        tasks.add(new Task("Ivan", "писать"));
        tasks.add(new Task("Petr", "рисовать"));
        tasks.add(new Task("Kolia", "гулять"));

        tasks.forEach(executorService::submit);
        executorService.shutdown();
    }
}
