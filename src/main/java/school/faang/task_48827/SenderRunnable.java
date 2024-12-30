package school.faang.task_48827;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
@AllArgsConstructor

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int startInd = getStartIndex(); startInd < getEndIndex(); startInd++) {
            int num = startInd + 1;
            executor.submit(() -> System.out.println("Письмо № "+ num +" отправлено"));
        }
    }
}
