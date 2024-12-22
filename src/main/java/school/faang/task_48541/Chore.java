package school.faang.task_48541;

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
            String name = Thread.currentThread().getName();
            System.out.printf("%s выполняет: %s %n", name, chore);
            Thread.sleep(3000);
            System.out.printf("%s выполнился %n", chore);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
