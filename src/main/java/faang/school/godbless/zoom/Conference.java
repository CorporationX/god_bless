package faang.school.godbless.zoom;

import lombok.Data;

import java.util.concurrent.CountDownLatch;

@Data
public class Conference {
    private int participantToStart;
    private CountDownLatch countDownLatch = new CountDownLatch(participantToStart);
    public void startStreaming(){
        try {
            countDownLatch.await();
            System.out.println("Starting streaming");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Conference(int participantToStart) {
        this.participantToStart = participantToStart;
    }
}
