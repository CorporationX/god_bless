package faang.school.godbless.thirdSprint.TheyWereVeryNice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " начал свою работу. Он будет " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName + " завершил свою работу.");
    }
}
