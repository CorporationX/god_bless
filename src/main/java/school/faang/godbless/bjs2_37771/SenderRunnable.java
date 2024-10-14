package school.faang.godbless.bjs2_37771;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(mailIndex -> System.out.println("Mail number " + mailIndex + " is sent"));
    }
}
