package ru.maks1979.task_48726;

public class MailSender {
    public static void main(String[] args) {
        SenderRunnable sender = null;
        int delta = 200;
        for (int i = 1; i < 6; i++) {
            sender = new SenderRunnable(sender.getStartIndex((delta*i-200)+i), sender.getEndIndex(delta*i));
            Thread thread = new Thread(sender);
            thread.start();
            try {
                thread.join();
                System.out.println("Главный поток дождался завершения Потока " + thread.getName());
            } catch (InterruptedException e) {
                System.out.println("Отправка писем успешно завершена.");
            }
        }

}}
