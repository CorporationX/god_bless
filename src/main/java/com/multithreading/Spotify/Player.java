package com.multithreading.Spotify;


import java.util.concurrent.TimeUnit;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock){
           if(!isPlaying){
               isPlaying = true;
               System.out.println(Thread.currentThread().getName() +  " is paying =" + isPlaying);
               System.out.println("Произведение играет ");
           }

        }
    }

    public void pause() {
        synchronized (lock){
            if(isPlaying){
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() +  " is paying =" + isPlaying);
                System.out.println("Произведение поставлено на паузу");
            }
        }

    }

    public void skip() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() +  " is paying =" + isPlaying);
            System.out.println("Следующая произведение ");
        }
    }

    public void previous() {
        synchronized (lock){
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() +  " is paying =" + isPlaying);
            System.out.println("Предыдущая произведение ");
        }
    }
}
