package were_nice_but_extremely_poor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println(chore);
    }

    public Chore(String chore) {
        this.chore = chore;
    }
}
