package theyWereNiceButExtremelyPoor;

import java.util.Random;

public class Chore implements Runnable{
    private static Random random = new Random();
    private int minDelay = 1000;
    private int maxDelay = 5000;
    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName() + " Выполняется");

            Thread.sleep(random.nextInt(minDelay, maxDelay));
            System.out.println(Thread.currentThread().getName() + " Закончено");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }
}
