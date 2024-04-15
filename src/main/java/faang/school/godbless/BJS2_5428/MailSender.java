package faang.school.godbless.BJS2_5428;

import lombok.SneakyThrows;

public class MailSender {
    @SneakyThrows
    public static void main(String[] args) {
        SenderRunnable senderRunnable = new SenderRunnable();
        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i + 1) * 200;
            threads[i] = new Thread(() -> senderRunnable.sendMessage(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nВсе сообщения отправлены");
    }
}
