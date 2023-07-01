package faang.school.godbless.multithreading_parallelism;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Message №" + i + " has been sent");
        }
    }
}
