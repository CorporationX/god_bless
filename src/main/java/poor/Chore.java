package poor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        final int millis = 1000;
        try {
            System.out.println(Thread.currentThread().getName() + " начинает задачу: " + chore);
            Thread.sleep(millis);
            System.out.println(Thread.currentThread().getName() + " завершил задачу: " + chore);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " был прерван.");
        }
    }

    @Override
    public String toString() {
        return "Chore: " + chore;
    }
}
