package faang.school.godbless.Multithreading.ParallelismAndThread.task08_TheyWereVeryNiceButExtremelyPoor;

import lombok.SneakyThrows;

public class Chore implements Runnable{
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" Задача "+ chore );
        Thread.sleep(1000);
    }
}
