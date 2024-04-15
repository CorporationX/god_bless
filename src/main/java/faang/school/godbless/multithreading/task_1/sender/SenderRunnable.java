package faang.school.godbless.multithreading.task_1.sender;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts work");
        System.out.printf("mail from %d to %d were send %n", startIndex, endIndex);
    }
}