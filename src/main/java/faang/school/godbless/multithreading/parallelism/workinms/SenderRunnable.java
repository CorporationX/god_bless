package faang.school.godbless.multithreading.parallelism.workinms;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderRunnable implements Runnable {

    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        System.out.println("Sending messages from index " + startIndex + " to " + endIndex);
    }
}
