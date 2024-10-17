package school.faang.BJS2_37791_WorkingInMicrosoft;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.rangeClosed(startIndex, endIndex)
                .forEach(index -> System.out.printf("Mail #%d has been sent\n", index));
    }
}
