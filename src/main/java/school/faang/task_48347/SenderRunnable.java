package school.faang.task_48347;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (var i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо номер " + i + " отправлено");
        }
    }
}
