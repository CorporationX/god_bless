package faang.school.godbless.sprint_3.multithreading.working_in_microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("%d message -> has been sent successfully%n", i);
        }
    }
}

