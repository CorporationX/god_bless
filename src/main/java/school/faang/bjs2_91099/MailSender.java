package school.faang.bjs2_91099;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailSender {


    private static final int START_INDEX = 0;
    private static final int END_INDEX = 200;

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        SenderRunnable firstSender = new SenderRunnable(START_INDEX, END_INDEX);
        SenderRunnable secondSender = new SenderRunnable(START_INDEX, END_INDEX);
        SenderRunnable thirdSender = new SenderRunnable(START_INDEX, END_INDEX);
        SenderRunnable fourthSender = new SenderRunnable(START_INDEX, END_INDEX);
        SenderRunnable fifthSender = new SenderRunnable(START_INDEX, END_INDEX);
        Thread firstThread = new Thread(firstSender);
        Thread secondThread = new Thread(secondSender);
        Thread thirdThread = new Thread(thirdSender);
        Thread fourthThread = new Thread(fourthSender);
        Thread fifthThread = new Thread(fifthSender);
        log.info("Запускаем обработчики писем");
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthThread.start();
        try {
            log.info("Ждем обработки писем от обработчиков");
            firstThread.join();
            log.info("Первый обработчик выполнил задачу? {}, обработано - {} сообщений",
                    firstThread.isAlive() ? "У нас проблемс..." : "Ок", firstSender.getStartIndex());
            secondThread.join();
            log.info("Второй обработчик выполнил задачу? {}, обработано - {} сообщений",
                    secondThread.isAlive() ? "У нас проблемс..." : "Ок", secondSender.getStartIndex());
            thirdThread.join();
            log.info("Третий обработчик выполнил задачу? {}, обработано - {} сообщений",
                    thirdThread.isAlive() ? "У нас проблемс..." : "Ок", thirdSender.getStartIndex());
            fourthThread.join();
            log.info("Четвертый обработчик выполнил задачу? {} обработано - {} сообщений",
                    fourthThread.isAlive() ? "У нас проблемс..." : "Ок", fourthSender.getStartIndex());
            fifthThread.join();
            log.info("Пятый обработчик выполнил задачу? {}, обработано - {} сообщений",
                    fifthThread.isAlive() ? "У нас проблемс..." : "Ок", fifthSender.getStartIndex());
            log.info("Отправка сообщений законченна! - отправленно {}", SenderRunnable.count.get());
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
