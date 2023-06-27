package faang.school.godbless.sprint4.multithreading_parallelism_thread.task8;

import lombok.SneakyThrows;

public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + chore);
        Thread.sleep(1000);
    }
}
