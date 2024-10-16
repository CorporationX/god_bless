package school.faang.microsoft;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("The letter has been sent: " + i);
        }
    }
}
