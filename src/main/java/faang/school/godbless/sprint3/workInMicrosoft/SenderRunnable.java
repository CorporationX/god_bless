package faang.school.godbless.sprint3.workInMicrosoft;

public class SenderRunnable implements Runnable {

    private Integer startIndex;
    private Integer endIndex;

    public SenderRunnable(Integer startIndex, Integer endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + ". " + "Sending mail with index: " + i);
        }
    }
}
