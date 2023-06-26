package sprint4.microsoft;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("%s was successfully justified from %s\n", MailSender.mails.get(i),
                    Thread.currentThread().getName());
        }
        System.out.printf("\n%s completed\n\n", Thread.currentThread().getName());
    }
}
