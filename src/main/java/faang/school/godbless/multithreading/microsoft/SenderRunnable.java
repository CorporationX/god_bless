package faang.school.godbless.multithreading.microsoft;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SenderRunnable implements Runnable{
    private final Integer startIndex;
    private final Integer endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Email%d is sent successfully! %s \n", i, Thread.currentThread().getName());
        }
    }
}
