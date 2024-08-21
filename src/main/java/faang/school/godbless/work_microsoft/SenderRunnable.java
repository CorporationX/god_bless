package faang.school.godbless.work_microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.IntStream;

@Getter
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .boxed()
                .peek(i -> System.out.println("Отправка сообщения №" + i))
                .toList();
    }
}
