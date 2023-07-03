package Sprint_4_Task8;

import lombok.SneakyThrows;

public class Chore implements Runnable{
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + chore);
        Thread.sleep(5000);
    }
}
