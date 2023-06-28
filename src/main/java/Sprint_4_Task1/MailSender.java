package Sprint_4_Task1;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;
            threadList.add( new Thread(new SenderRunnable(startIndex,endIndex)));
        }
        for(Thread thread : threadList){
            thread.start();
        }
        for (Thread thread : threadList){
            thread.join(100);
        }
        System.out.println(" Поле");
    }
}
