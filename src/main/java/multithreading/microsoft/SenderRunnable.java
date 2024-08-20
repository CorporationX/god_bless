package multithreading.microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.IntStream;

@Getter
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .boxed()
                .peek(i -> System.out.println("Sending message № " + i))
                .toList();
    }
}
