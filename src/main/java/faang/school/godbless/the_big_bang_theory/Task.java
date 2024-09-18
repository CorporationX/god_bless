package faang.school.godbless.the_big_bang_theory;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        log.info("Задача начата");

        System.out.println(name + " приступил к " + task);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.info("Задача прервана");
        }

        log.info("Задача завершена");

        System.out.println(name + " закончил " + task);
    }
}
