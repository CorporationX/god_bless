package com.multitheading.tournament;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Trial implements Runnable {
    private String nameTrial;
    private String nameKnight;

    @Override
    public void run() {
        System.out.println(nameKnight + " назначено испытание " + nameTrial);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Испытание " + nameTrial + " для " + nameKnight + " прервано");
        }
        System.out.println(nameKnight + " испытание " + nameTrial + " прошел");
    }
}
