package school.faang.spring3.task_48523;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()
                    + " начал выполнять задачу " + chore);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()
                    + " закончил выполнять задачу " + chore);
        } catch (InterruptedException e) {
            throw new RuntimeException("Задача была прервана");
        }

    }
}
