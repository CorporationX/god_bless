package faang.school.godbless.BJS2_23688;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable {
    private final int START_INDEX;
    private final int END_INDEX;

    @Override
    public void run() {
        for (int i = START_INDEX; i <= END_INDEX; i++) {
            System.out.println("Mail " + i + " sent by thread " + Thread.currentThread().getName());
        }
    }
}
