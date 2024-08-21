package faang.school.godbless.mail_sender;
import java.util.stream.IntStream;

public class SenderRunnable implements Runnable {
    private final int startIdx;
    private final int endIdx;

    public SenderRunnable(int startIdx, int endIdx) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(startIdx, endIdx)
                .forEach(i -> System.out.println("Sending email #" + i));
    }
}
