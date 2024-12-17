package school.faang.sprint_3.task_43554;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено: " + i);
        }
    }
}
