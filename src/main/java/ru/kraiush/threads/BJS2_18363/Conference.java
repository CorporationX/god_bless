package ru.kraiush.threads.BJS2_18363;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Getter
@Setter
@ToString
public class Conference extends Thread {

    private  List<Thread> listParticipants;
    private CountDownLatch latch;

    public Conference(List<Thread> listParticipants, CountDownLatch latch, String name) {
        super(name);
        this.listParticipants = listParticipants;
        this.latch = latch;
    }

    @Override
    public void run() {
        listParticipants.forEach(Thread::start);
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n" + Thread.currentThread().getName() + ": all participants joined the conference");
        System.out.println("\nLet's start!");
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
