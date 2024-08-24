package thread.five;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chore implements Runnable {

    private String chore;

    @Override
    public void run() {
        System.out.println(chore + " выполняется с помощью " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
            System.out.println(chore + " готов.");
        } catch (InterruptedException e) {
            System.out.println("Выполнение задачи было прервано.");
        }
    }
}
