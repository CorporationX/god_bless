package faang.school.godbless.spring_4.they_were_very_nice_but_extremely_poor;

import java.util.concurrent.TimeUnit;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    public String getChore() {
        return chore;
    }

    public void setChore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.printf("%s выполняет задачу %s \n", Thread.currentThread().getName(), chore);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
