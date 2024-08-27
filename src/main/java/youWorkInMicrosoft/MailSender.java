package youWorkInMicrosoft;

import java.util.ArrayList;
import java.util.List;

public class MailSender {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> listOfMails = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            listOfMails.add(i);
        }
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SenderRunnable(i * 200, (i + 1) * 200, listOfMails));
            thread.start();
            thread.join();
        }
        System.out.println("Все сообщения отправлены");
    }
}
