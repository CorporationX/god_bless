package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int poolSize = 200;
        int numberOfThread = 5;
        int startIndex = 0;
        int endIndex;

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < numberOfThread; i++) {
            //вычислить индексы
            endIndex = startIndex + poolSize - 1;
            //назначить потоку задание с начальным и конечным индексами
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            threadList.add(thread);
            //пересчитать индексы
            startIndex += poolSize;
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("Сообщения отправлены");
    }
}

