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
public class MarketingResources implements Runnable {

    private Lock lock1;
    private Lock lock2;
    List<String> listMarketing;
    List<String> listDesigns;

    public void run() {
        boolean done = false;
        while (!done) {
            if (lock2.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": got LOCK-2. Trying for lOCK-1");
                    String elem = listDesigns.get(new Random().nextInt(9));
                    System.out.println(Thread.currentThread().getName() + " - " + listMarketing.get(new Random().nextInt(9)) + " - " + elem);
                    listMarketing.add("added new from design files: " + elem);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (lock1.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + ": got LOCK-1.");
                            done = true;
                        } finally {
                            lock1.unlock();
                        }
                    }
                } finally {
                    lock2.unlock();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
