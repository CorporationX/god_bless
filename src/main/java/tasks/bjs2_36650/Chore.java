package tasks.bjs2_36650;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println("Задача : " + chore);
            System.out.println(Thread.currentThread().getName() + ": Выполняется");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + ": Выполнено");
        } catch (InterruptedException e) {
            throw new IllegalStateException("В процессе выполнения задачи " + chore + " произошла ошибка : " + e.getMessage());
        }
    }
}
