package WorksAtMicrosoft;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class SenderRunnable implements Runnable {

    //Отправитель Работоспособен
    @Getter
    @Setter
    private List<String> messages; // Список сообщений для отправки
    @Getter
    @Setter
    private static int start; // Начальный индекс для этого потока
    @Getter
    @Setter
    private static int end; // Конечный индекс для этого потока



    public SenderRunnable(List messages, int start, int end) {
        this.messages = messages;
        SenderRunnable.start = start;
        SenderRunnable.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sendMessage(messages.get(i)); // Отправка сообщения
        }
    }
    public static void sendMessage(String message) {
        System.out.println("Отправка сообщения: " + message);
    }

}

