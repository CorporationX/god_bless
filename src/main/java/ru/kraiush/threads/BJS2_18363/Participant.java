package ru.kraiush.threads.BJS2_18363;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
public class Participant extends Thread {

    private String participant;
    private CountDownLatch latch;

    public Participant(String participant, CountDownLatch latch, String name) {
        super(name);
        this.participant = participant;
        this.latch = latch;
    }

    @Override
    public void run() {
        joinConference();
    }

    @Override
    public String toString() {
        return "Participant{" + participant + "}";
    }

    void joinConference() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 6000));
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " joined the conference");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
