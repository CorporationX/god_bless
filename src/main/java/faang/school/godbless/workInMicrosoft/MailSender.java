package faang.school.godbless.workInMicrosoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int lettersForThread = 200;
        for (int i = 0; i < 5; i++) { // запускаем 5 потоков
            var thread = new Thread(new SenderRunnable(lettersForThread * i, lettersForThread * i + lettersForThread));
            // каждому потоку присваиваем нужное кол-во писем
            thread.start(); // запуск потоков
            thread.join();
        }
    }
}
