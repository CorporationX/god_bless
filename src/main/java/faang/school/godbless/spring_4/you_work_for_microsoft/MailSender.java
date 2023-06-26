package faang.school.godbless.spring_4.you_work_for_microsoft;

import java.util.List;

public class MailSender {

    public void sendEmails(List<Thread> threads) {
        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("error");
            }
        });
    }
}
