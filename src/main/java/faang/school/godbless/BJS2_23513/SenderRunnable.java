package faang.school.godbless.BJS2_23513;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(Thread.currentThread().getName() + ": sent message numer " + i);
        }
    }
}
