package school.faang.microsoft;

import java.util.stream.IntStream;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(i -> System.out.println("Письмо " + i + " отправлено потоком "
                        + Thread.currentThread().getName()));
    }
}