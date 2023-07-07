package faang.school;

import lombok.AllArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Participant implements Runnable {
    private Conference conference;

    public void joinConference() {
        System.out.println(Thread.currentThread().getName() + " wanted to join");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        conference.joinStream();
    }

    @Override
    public void run() {
        joinConference();
    }
}
