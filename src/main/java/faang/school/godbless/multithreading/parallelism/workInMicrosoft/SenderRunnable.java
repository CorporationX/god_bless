package faang.school.godbless.multithreading.parallelism.workInMicrosoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int start = startIndex; start<= endIndex; start++) {
            System.out.println("Message sent" + Thread.currentThread());
        }
    }
}
