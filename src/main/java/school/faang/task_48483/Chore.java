package school.faang.task_48483;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        try {
            System.out.printf("Поток: %s\n Выполняет задачу: %s ", Thread.currentThread().getName(), chore);
            Thread.sleep(1000);
            System.out.println(chore + " - задача выполнена!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
