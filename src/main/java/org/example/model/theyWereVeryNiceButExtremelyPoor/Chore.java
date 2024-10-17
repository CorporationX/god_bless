package org.example.model.theyWereVeryNiceButExtremelyPoor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            System.out.println("задача " + chore + " начался");
            Thread.sleep(1000);
            System.out.println("задача " + chore + " закончена");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}