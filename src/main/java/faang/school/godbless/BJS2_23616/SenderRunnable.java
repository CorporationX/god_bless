package faang.school.godbless.BJS2_23616;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.stream.IntStream;


@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(num -> System.out.printf("Letter #%d: send success\n", num + 1));
    }
}
