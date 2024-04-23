package task12;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private List<String> messages;
    private int startIndex;
    private int endIndex;

    public void run() {
        for (int i = startIndex; i <= endIndex; i++)
            System.out.println("Сообщение \"" + messages.get(i) + "\" отправлено.");
    }
}