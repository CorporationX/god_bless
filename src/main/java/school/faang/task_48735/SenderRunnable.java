package school.faang.task_48735;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final Integer startIndex;
    private final Integer endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо " + i + " отправлено");
        }
    }
}
