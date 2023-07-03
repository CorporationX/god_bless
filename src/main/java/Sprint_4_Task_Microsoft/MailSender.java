package Sprint_4_Task_Microsoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int start = i * 200 + 1;
            int end = i * 200 + 200;
            threads.add(new Thread(new SenderRunnable(start, end)));
        }
        for(Thread oneThread: threads){
            oneThread.start();
        }
    }
}