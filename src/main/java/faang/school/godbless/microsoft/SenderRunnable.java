package faang.school.godbless.microsoft;

import lombok.Data;

import java.util.ArrayList;
import java.util.Queue;

@Data
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    private ArrayList<String> stringsPool = new ArrayList<>();

    public SenderRunnable(int startIndex,
                          int endIndex, Queue<String> stringsQueue) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        //создаём для каждого объекта свой пул строк в зависимости от индексов
        for (int i = startIndex; i <= endIndex; i++) {
            this.stringsPool.add(stringsQueue.poll());
        }
    }

    public static void sendMail(ArrayList<String> mailsPool) {
        mailsPool.forEach(string -> System.out.printf(
                "Письмо %s было успешно отправлено!\n", string));
    }

    @Override
    public void run() {
        SenderRunnable.sendMail(stringsPool);
    }
}
