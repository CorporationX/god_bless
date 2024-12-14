package school.faang.task48060;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex).forEach(i -> {
            Thread thread = Thread.currentThread();
            System.out.printf("%s письмо %d отправлено%n", thread.getId(), i);
        });
    }
}
