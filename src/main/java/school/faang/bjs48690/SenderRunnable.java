package school.faang.bjs48690;

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
        IntStream.rangeClosed(startIndex, endIndex)
                .forEach(n -> System.out.println("letter " + n + " successfully delivered"));
    }
}
