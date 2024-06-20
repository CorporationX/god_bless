package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        // создаём очередь из писем
        Queue<String> inputMails = new LinkedList<>();

        for (int i = 1; i <= 1000; i++) {
            inputMails.offer("Письмо " + i);
        }

// создаём список объектов пулов строк
        List<SenderRunnable> senderRunnables = new ArrayList<>();

        // создаём объекты пулов строк и заполняем список пулов строк
        SenderRunnable senderRunnable1
                = new SenderRunnable(1, 200, inputMails);
        senderRunnables.add(senderRunnable1);

        SenderRunnable senderRunnable2
                = new SenderRunnable(201, 400, inputMails);
        senderRunnables.add(senderRunnable2);

        SenderRunnable senderRunnable3
                = new SenderRunnable(401, 600, inputMails);
        senderRunnables.add(senderRunnable3);

        SenderRunnable senderRunnable4
                = new SenderRunnable(601, 800, inputMails);
        senderRunnables.add(senderRunnable4);

        SenderRunnable senderRunnable5
                = new SenderRunnable(801, 1000, inputMails);
        senderRunnables.add(senderRunnable5);

        List<Thread> threads = new ArrayList<>();
//       создаём потоки, в каждый из  которых передаём объект пула строк
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(senderRunnables.get(i), "Поток " + (i + 1));
            threads.add(thread);
            thread.start();
            System.out.println(thread.getName() + " запущен");
        }

        //сообщаем основному потоку, чтобы он ждал завершения всех потоков
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //после завершения всех потоков выводим сообщение
        if (threads.stream()
                .filter(Thread::isAlive)
                .toList()
                .isEmpty()) {
            System.out.println("Все письма были отправлены!");
        }
    }
}

