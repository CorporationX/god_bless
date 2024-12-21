package school.faang.sprint_3.task_48730;

import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class SenderRunnable implements Callable<String> {
    private final int startIndex;
    private final int endIndex;

    @Override
    public String call() {
        String sentLetters = IntStream.range(startIndex, endIndex)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        return sentLetters.isEmpty() ? "Письма отправлены:" : "Письма отправлены: " + sentLetters;
    }
}
