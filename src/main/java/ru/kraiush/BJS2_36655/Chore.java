package ru.kraiush.BJS2_36655;

import lombok.Getter;

@Getter
public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is doing the chore: " + chore);
            Thread.sleep(1000);
            System.out.println(chore + " is completed.");
        } catch (InterruptedException e) {
            System.out.println(chore + " was interrupted!");
        }
    }
}
