package faang.school.godbless.task.Microsoft;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SenderRunnable implements Runnable{
    private List<String> messages;
    private int startIndex;
    private int endIndex;
    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println(messages.get(i));
        }
    }
}
