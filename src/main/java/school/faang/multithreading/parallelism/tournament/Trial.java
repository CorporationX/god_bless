package school.faang.multithreading.parallelism.tournament;

import lombok.SneakyThrows;

import java.util.Random;

public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    private Random random = new Random();

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - рыцарь " + this.knightName + " начал испытание " + this.trialName);
        Thread.sleep(random.nextInt(10000) + 3000);
        System.out.println(Thread.currentThread().getName() + " - рыцарь " + this.knightName + " завершил испытание " + this.trialName);
    }

    @Override
    public String toString() {
        return trialName;
    }
}
