package ru.kraiush.threads.BJS2_18339;

import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class Player extends Thread {

    private int maxPlayers;
    private final Queue<Member> queue;
    private Member member;

    public Player(Queue<Member> queue, int maxSize, Member member) {
        this.queue = queue;
        this.maxPlayers = maxSize;
        this.member = member;
    }

    @Override
    public void run() {
//        while (true) {
        synchronized (queue) {
            while (queue.size() == maxPlayers) {
                try {
                    queue.wait();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            queue.add(member);
            queue.notifyAll();
        }
//        }
    }

    @Override
    public String toString() {
        return "player { " + member + "}";
    }
}
