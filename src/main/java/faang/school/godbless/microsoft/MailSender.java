package faang.school.godbless.microsoft;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MailSender {

    public static void main(String[] args) {

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = 200 * i + 1;
            int endIndex = 200 * (i + 1);
            threads[i]= new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for(Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All letters have been successfully sent");
    }
}
