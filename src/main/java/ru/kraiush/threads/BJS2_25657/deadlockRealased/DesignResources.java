package ru.kraiush.threads.BJS2_25657.deadlockRealased;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DesignResources implements Runnable {

    private Lock lock1;
    private Lock lock2;
    List<String> listDesigns;
    List<String> listMarketings;

    public void run() {
        boolean done = false;
        while (!done) {
            if (lock1.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": got LOCK-1. Trying for LOCK-2");
                    String elem = listMarketings.get(new Random().nextInt(9));
                    System.out.println(Thread.currentThread().getName() + " - " + listDesigns.get(new Random().nextInt(9)) + " - " + elem);
                    listDesigns.add("added new from marketing files: " + elem);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (lock2.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ": got LOCK-2.");
                            done = true;
                        } finally {
                            lock2.unlock();
                        }
                    }
                } finally {
                    lock1.unlock();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
