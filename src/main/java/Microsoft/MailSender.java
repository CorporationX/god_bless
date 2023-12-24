package Microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int numberOfMessages = 1000;

        int poolSize = 200;
        int poolCounter = 0;
        int numberOfThreads = 5;
        int startIndex = 0;
        int endIndex;


        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i <= numberOfMessages; i++) {
            //Если пул сообщений == 0
            if (poolCounter == 0) {
                //Записываем startIndex
                startIndex = i;
            }


            //Если counter == 200
            if (poolCounter == poolSize) {
                //Записываем endIndex
                endIndex = i;
                //Запускаем отправку группы писем
                executorService.submit(new SenderRunnable(startIndex, endIndex));

                //Сбрасываем counter
                poolCounter = 0;
            }

            //Инкрементируем счетчик
            poolCounter++;

            //Если дошли до конца списка но counter != 200
            if (i == numberOfMessages) {
                //Отправляем оставшиеся
                endIndex = i;

                SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
                senderRunnable.run();

            }

        }
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
        executorService.shutdown();
    }
}

