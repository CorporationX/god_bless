package faang.school.godbless.work_in_microsoft;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .forEach(i -> System.out.println("Отправка сообщения " + i + " из потока " + Thread.currentThread().getName()));
    }
}
