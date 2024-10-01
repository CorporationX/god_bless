package WorksAtMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class EmailClient {

    public static void main(String[] args) {
        List messages = new ArrayList<>();
        // Наполнили список сообщений 1000 сообщениями
        for (int i = 1; i <= 1000; i++) {
            messages.add("Сообщение электронной почты " + i);
        }
        SenderRunnable senderRunnable = new SenderRunnable(messages, 1, 200);

        List<String> threads = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++) {
            threads.add((String) messages.get(i));
            if (i + 1 % SenderRunnable.getEnd() == 0) {
                new Thread(() -> senderRunnable.sendMessage(threads.toString())).start();
            }
        }
        System.out.println("Все сообщения отправлены!");
    }
}