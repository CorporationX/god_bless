package faang.school.godbless.Microsoft;

public class MailSender {
    public static void main(String[] args) {
        int mailThreads = 200;
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++){
            int startIndex = i * mailThreads + 1;
            int endIndex = startIndex + mailThreads;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();

        }
        for (int i = 0; i < numThreads; i++){
            try{
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Все сообщения были отправлены");
    }

}




