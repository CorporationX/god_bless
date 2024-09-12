package ru.kraiush.threads.BJS2_18365;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AppAcceptanceBase {

    public static void main(String[] args) {

        final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread pentagon = new MilitaryBase(queue, true);
        pentagon.setName("Pentagon");
        pentagon.start();

        Thread langley = new MilitaryBase(queue, false);
        langley.start();

        try {
            TimeUnit.MILLISECONDS.sleep(7500);
            pentagon.interrupt();
            langley.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
