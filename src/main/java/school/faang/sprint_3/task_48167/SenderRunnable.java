package school.faang.sprint_3.task_48167;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class SenderRunnable implements Callable<String> {
    private final int startIndex;
    private final int endIndex;


    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Письма отправлены: ");
        for (int i = startIndex; i < endIndex; i++) {
            stringBuilder.append(i);
            stringBuilder.append(' ');
        }
        return stringBuilder.toString().trim();
    }
}
