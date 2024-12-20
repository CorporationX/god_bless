package school.faang.sprint3.task1;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    private static final int THREADS_NUM = 5;
    private static final int MESSAGES_PER_THREAD = 200;


    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();


        for (int i = 0; i < THREADS_NUM; i++) {
            int start = i * MESSAGES_PER_THREAD;
            int end = start + MESSAGES_PER_THREAD;

            threads.add(new Thread(new SenderRunnable(start, end)));
            threads.get(i).start();

            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //ТУТ ПОПЫТАЛСЯ ПОВЫПЕНДРИВАТЬСЯ, НО УВЫ, НЕТ СИНХРОНИЗАЦИИ
        //Ну в принципе логично, так как стримы сами тоже потоки по сути
        //Вернее некоторые их методы

        /*
        threads.stream()
                .forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
        */
        System.out.println("All messages sent");
    }
}
