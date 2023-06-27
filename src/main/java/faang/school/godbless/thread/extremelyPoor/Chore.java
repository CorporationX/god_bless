package faang.school.godbless.thread.extremelyPoor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Chore implements Runnable{
    private String task;

    @SneakyThrows
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " начал выполнение задачи " + task);
        TimeUnit.SECONDS.sleep(5);
        System.out.println(threadName + " закончил выполнение задачи " + task);
    }
}
