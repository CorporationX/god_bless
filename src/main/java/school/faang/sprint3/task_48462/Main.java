package school.faang.sprint3.task_48462;

public class Main {
    private static Thread thread1;

    public static void main(String[] args) {
        final int numberOfLetters = 1000;
        final int numberOfThreads = 5;
        for (int i = 0; i < numberOfLetters; i += numberOfLetters / numberOfThreads) {
            final Thread thread = new Thread(new SenderRunnable(i + 1, i + numberOfLetters / numberOfThreads));
            thread.start();
        }
    }
}