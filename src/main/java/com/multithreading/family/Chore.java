package com.multithreading.family;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Выполняет задачу: " + chore);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Задача прервана " + chore);
        }
        System.out.println(Thread.currentThread().getName() + " Выполнил задачу: " + chore);
    }
}
