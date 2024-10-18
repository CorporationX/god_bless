package ru.kraiush.BJS2_36389;

public class Main {
    public static void main(String[] args) {
        Thread pig1Thread = new Pig1Thread();
        Thread pig2Thread = new Pig2Thread();
        Thread pig3Thread = new Pig3Thread();

        pig1Thread.start();
        pig2Thread.start();
        pig3Thread.start();

        try {
            pig1Thread.join();
            pig2Thread.join();
            pig3Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The game is over!");
    }
}
