package school.faang.multithreading.microsoft;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        for(int i = startIndex; i <= endIndex; i ++) {
            System.out.println("Message sent" + i);
        }
    }
}
