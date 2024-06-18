package faang.school.godbless.they_were_very_nice_but_extremely_poor;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.printf("Doing '%s' from '%s'\n", this.chore, Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(3000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(String.format("'%s' failed from '%s'", this.chore, Thread.currentThread().getName()));
        }
        System.out.printf("Finished '%s' from '%s'\n", this.chore, Thread.currentThread().getName());
    }
}
