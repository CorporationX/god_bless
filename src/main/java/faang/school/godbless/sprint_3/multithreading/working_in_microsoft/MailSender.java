package faang.school.godbless.sprint_3.multithreading.working_in_microsoft;

import java.util.List;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = List.of("Hello World", "The battle begin!", "It's Jonny", "The password is 23355", "We expect more");
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endindex = (i + 1) * 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, endindex, list.get(i)));
            thread.start();
            thread.join();
        }
    }
}
