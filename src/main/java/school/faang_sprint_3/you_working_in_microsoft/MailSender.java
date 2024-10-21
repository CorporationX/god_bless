package school.faang_sprint_3.you_working_in_microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {

    public static void main(String[] args) {
        var lettersAmount = 1000;
        var threadsAmount = 5;
        var partition = lettersAmount / threadsAmount;

        var threads = new Thread[threadsAmount];
        for (int i = 0; i < threads.length; i++) {
            var begin = i * partition;
            var end = (i + 1) * partition;
            threads[i] = new Thread(new SenderRunnable(begin, end));
            threads[i].start();
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("An exception occurred", e);
                throw new ThreadInterruptException("Thread interrupted" + e.getMessage());
            }
        }
        log.info("Successfully finished");
    }
}
