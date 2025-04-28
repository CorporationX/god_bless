package school.faang.big_bang_theory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        log.info("{} начал выполнение задачи", name);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Выполнение задачи прервалось из-за непридвиденной ошибки");
        }
        log.info("{} выполнено", task);
    }
}
