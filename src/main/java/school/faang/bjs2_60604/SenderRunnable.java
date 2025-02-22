package school.faang.bjs2_60604;

import lombok.AllArgsConstructor;

import java.util.stream.IntStream;

@AllArgsConstructor
public class SenderRunnable  implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        IntStream.range(startIndex, endIndex)
                .mapToObj(i -> "Письмо %dd отправлено")
                .forEach(System.out::println);
    }
}
