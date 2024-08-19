package faang.school.godbless.modul3.workinmicrosoft;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .mapToObj(i -> "Email " + i + " sent")
                .forEach(System.out::println);
    }
}
