package faang.school.godbless.BJS2_11858;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    private static final int THREAD_NUMS = 5;
    private static final int QUANTITY = 1010;

    public static void main(String[] args) {
        int count = 0;
        int n = 0;
        for (int i = 0; i <= QUANTITY + (THREAD_NUMS - 1); i++) {
            count++;
            if (count == 200) {
                var thread = new Thread(new SenderRunnable(i - 199 + n, i + 1 + n));
                n++;
                count = 0;
                thread.start();
            }
            if (n == THREAD_NUMS && i < QUANTITY + (THREAD_NUMS - 1)) {
                var thread = new Thread(new SenderRunnable((i + 1 + n), QUANTITY + (THREAD_NUMS - 1)));
                thread.start();
                break;
            }
        }
    }
}
