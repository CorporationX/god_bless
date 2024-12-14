package something;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            Thread.sleep(300); //почему при значении больше 600 срабатывает ошибка?
            String name = Thread.currentThread().getName();
            System.out.println(name + " - задача: " + chore);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
