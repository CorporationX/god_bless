package faang.school.godbless.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MailSender {
    public static void main(String[] args) {

        Queue<String> inputMails = new LinkedList<>();
        List<String> mailPool1 = new ArrayList<>();
        List<String> mailPool2 = new ArrayList<>();
        List<String> mailPool3 = new ArrayList<>();
        List<String> mailPool4 = new ArrayList<>();
        List<String> mailPool5 = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            inputMails.offer("Письмо " + i);
        }
        System.out.println("inputMails = " + inputMails);

        SenderRunnable senderRunnable1 = new SenderRunnable(1, 200);
        SenderRunnable senderRunnable2 = new SenderRunnable(201, 400);
        SenderRunnable senderRunnable3 = new SenderRunnable(401, 600);
        SenderRunnable senderRunnable4 = new SenderRunnable(601, 800);
        SenderRunnable senderRunnable5 = new SenderRunnable(801, 1000);

        for (int i = senderRunnable1.getStartIndex(); i <= senderRunnable1.getEndIndex() ; i++) {
            mailPool1.add(inputMails.poll());
        }
        for (int i = senderRunnable2.getStartIndex(); i <= senderRunnable2.getEndIndex() ; i++) {
            mailPool2.add(inputMails.poll());
        }
        for (int i = senderRunnable3.getStartIndex(); i <= senderRunnable3.getEndIndex() ; i++) {
            mailPool3.add(inputMails.poll());
        }
        for (int i = senderRunnable4.getStartIndex(); i <= senderRunnable4.getEndIndex() ; i++) {
            mailPool4.add(inputMails.poll());
        }
        for (int i = senderRunnable5.getStartIndex(); i <= senderRunnable5.getEndIndex() ; i++) {
            mailPool5.add(inputMails.poll());
        }

        System.out.println("mailPool1 = " + mailPool1);
        System.out.println("mailPool2 = " + mailPool2);
        System.out.println("mailPool3 = " + mailPool3);
        System.out.println("mailPool4 = " + mailPool4);
        System.out.println("mailPool5 = " + mailPool5);
        System.out.println("inputMails = " + inputMails);

//        for (int i = 0; i < 5; i++) {
//
//            Thread thread = new Thread(new SenderRunnable(), "Поток " + i);
//            thread.start();
//        }
    }
}
