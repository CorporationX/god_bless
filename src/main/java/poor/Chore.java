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
        try {
            System.out.println(Thread.currentThread().getName() + " начинает задачу: " + chore);
            Thread.sleep(1000);
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
