package faang.school.godbless.work_at_microsoft;

import java.util.List;

public class MailSender {
    public static void main(String[] args) {
        List<Thread> list = List.of(
                new Thread(new SenderRunnable(0, 200)),
                new Thread(new SenderRunnable(200, 400)),
                new Thread(new SenderRunnable(400, 600)),
                new Thread(new SenderRunnable(600, 800)),
                new Thread(new SenderRunnable(800, 1000))
                );

        sendMail(list);
    }

    public static void sendMail(List<Thread> list){
        list.stream().forEach(t -> t.start());
        list.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e){
                throw new RuntimeException("Email wasn't sent");
            }
        });
        System.out.println("DONE!");
    }
}
