package sprint4.microsoft;

import java.util.List;

public record SenderRunnable(List<String> mails) implements Runnable {
    @Override
    public void run() {
        for (String mail : mails) {
            System.out.printf("%s was successfully justified from %s\n", mail,
                    Thread.currentThread().getName());
        }
        System.out.printf("\n%s completed\n\n", Thread.currentThread().getName());
    }
}
