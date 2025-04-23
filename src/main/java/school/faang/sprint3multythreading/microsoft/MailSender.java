package school.faang.sprint3multythreading.microsoft;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        SenderRunnable senderRunnable = new SenderRunnable(1, 200);
        Thread thread1 = new Thread(senderRunnable);
        Thread thread2 = new Thread(senderRunnable);
        Thread thread3 = new Thread(senderRunnable);
        Thread thread4 = new Thread(senderRunnable);
        Thread thread5 = new Thread(senderRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            log.error("Прерывание потока. Что-то пошло не так. Смотри ошибки: {}", e.getMessage());
        }
        System.out.println("Все письма успешно отправлены!!!");
    }
}