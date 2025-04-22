package school.faang.ron;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Chore implements Runnable {

    private final String chore;
    @Override
    public void run() {
        try {
            System.out.println("Поток " +  Thread.currentThread().getName() +
                    " выполняет задачу " +chore);
            Thread.sleep(2000);
            System.out.println("Выполнена ");
        } catch (InterruptedException e) {
            System.out.println("Задача остановлена " + chore);
            throw new RuntimeException(e);
        }
    }
}
