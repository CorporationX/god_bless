package com.multithreading.microsoft;

public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;
    private final String color;
    public static final String RESET = "\u001B[0m";

    public SenderRunnable(int startIndex, int endIndex, String color) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.color = color;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(color + Thread.currentThread().getName() + " Успешно отправлено = " + i + RESET);
        }
    }
}
