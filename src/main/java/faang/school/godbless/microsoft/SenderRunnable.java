package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@Data
//@AllArgsConstructor
public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    private ArrayList<String> stringsPool;

    public SenderRunnable(int startIndex,
                          int endIndex, Queue<String> stringsQueue) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        for (int i = startIndex-1; i < endIndex; i++) {
            this.stringsPool.add(stringsQueue.peek());
        }
//        this.stringsPool = new ArrayList<>()
    }



    public static void sendMail(ArrayList<String> mailsPool) {
        mailsPool.forEach(string -> System.out.printf(
                "Письмо %s было успешно отправлено!", string));
    }

    @Override
    public void run() {
        SenderRunnable.sendMail(stringsPool);
    }
}
