package faang.school.godbless.task34;

import lombok.Data;

@Data
public class Chore implements Runnable{
    private String chore;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public Chore(String chore) {
        this.chore = chore;
    }
}
