package faang.school.godbless.BJS2_23860;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int id;
    private int start;
    private int end;

    @Override
    public void run() {
        IntStream.rangeClosed(start, end)
                .forEach(i -> System.out.printf("Поток %d отправил письмо номер: %d%n", id, i));
    }
}
