package faang.school.godbless.sprint.three.microsoft;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(i -> System.out.printf("Mail %d send successfully%n", i));
    }
}
