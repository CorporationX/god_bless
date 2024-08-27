package ru.kraiush.threads.BJS2_23817;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " " + trialName + " - " + Thread.currentThread().getName() + " --- Start: "+new Date());
        processSleep();
        System.out.println(knightName + " " + trialName + " - " + Thread.currentThread().getName() + " --- End = "+new Date());
    }

    private void processSleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
