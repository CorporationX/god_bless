package school.faang.bjs2_73035;

import java.util.ArrayList;
import java.util.List;

import static school.faang.bjs2_73035.MainSenderProperty.BATCH_SIZE;
import static school.faang.bjs2_73035.MainSenderProperty.THREADS_COUNT;

public class MailSender {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREADS_COUNT; i++) {
            final int startIndex = i * BATCH_SIZE;
            final int endIndex = startIndex + BATCH_SIZE;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException();
            }
        });
        System.out.println("Все письма успешно отправлены");
    }
}
