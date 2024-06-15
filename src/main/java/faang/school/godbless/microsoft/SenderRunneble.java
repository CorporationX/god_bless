package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunneble implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(i -> System.out.println("Письмо " + i + " доставлено"));
    }
}
