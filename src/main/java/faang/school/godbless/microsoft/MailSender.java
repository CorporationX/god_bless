package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MailSender {
    public static void main(String[] args) {

        Queue<String> inputMails = new LinkedList<>();
        ArrayList<String> mailPool1 = new ArrayList<>();
        List<String> mailPool2 = new ArrayList<>();
        List<String> mailPool3 = new ArrayList<>();
        List<String> mailPool4 = new ArrayList<>();
        List<String> mailPool5 = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            inputMails.offer("Письмо " + i);
        }
        System.out.println("inputMails = " + inputMails);

        for (int i = 0; i < 201; i++) {
            mailPool1.add(inputMails.peek());
        }

        System.out.println("mailPool1 = " + mailPool1);

//        SenderRunnable senderRunnable1 =
//                new SenderRunnable(1,200, inputMails);

//        System.out.println("mailPool1 = " + mailPool1);
//        System.out.println("inputMails = " + inputMails);
//        System.out.println("senderRunnable1 = " + senderRunnable1);
//        for (int i = 0; i < 5; i++) {
//
//            Thread thread = new Thread(senderRunnable1, "Поток " + i);
//            thread.start();
//        }
    }
}
