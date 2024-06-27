package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_1_microsoft;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Message: " + i);
        }
    }
}
