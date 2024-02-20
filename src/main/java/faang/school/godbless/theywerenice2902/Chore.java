package faang.school.godbless.theywerenice2902;

import lombok.Getter;

@Getter
public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is magically " + this.getChore());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
