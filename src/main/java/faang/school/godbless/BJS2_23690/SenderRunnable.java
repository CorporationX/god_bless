package faang.school.godbless.BJS2_23690;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(index -> System.out.println("Оправка письма №" + index));
    }
}
