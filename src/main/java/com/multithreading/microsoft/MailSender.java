package com.multithreading.microsoft;

import java.util.Arrays;
import java.util.List;

public class MailSender {
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        List<String> colors = Arrays.asList(BLUE, RED, GREEN, YELLOW, PURPLE);
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex, colors.get(i)));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Конец");
    }


}
