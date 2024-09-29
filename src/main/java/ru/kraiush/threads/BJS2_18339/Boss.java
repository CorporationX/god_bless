package ru.kraiush.threads.BJS2_18339;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@Slf4j
public class Boss extends Thread {

    private final Queue<Member> queue;
    private int maxPlayers;

    public Boss(Queue<Member> queue, int maxSize) {
        this.queue = queue;
        this.maxPlayers = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("<<<Oh, the player " + queue.remove() + " played with the boss!>>>");
                queue.notifyAll();
            }
        }
    }
}
