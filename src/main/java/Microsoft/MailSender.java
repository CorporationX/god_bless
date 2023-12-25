package Microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        int poolSize = 200;
        int numberOfThread = 5;
        int startIndex = 0;
        int endIndex;


        for (int i = 0; i < numberOfThread; i++) {
            //вычислить индексы
            endIndex = startIndex + poolSize - 1;
            //назначить потоку задание с начальным и конечным индексами
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            //пересчитать индексы
            startIndex += poolSize;
            thread.join();
        }

        System.out.println("Сообщения отправлены");
    }
}

